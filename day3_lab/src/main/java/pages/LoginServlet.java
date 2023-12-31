package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// centralized err handling in servlets :
			// How to tell WC that init has failed n not to continue
			// with the service phase : simply throw ServletException
			// to the WC
			// ServletException(String mesg,Throwable rootCause)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// clean up dao
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy of " + getClass() + " " + e);
			// how to inform the WC ?
			// throw new RuntimeException("err in destroy of "+getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get PW to send the resp from servlet --> clnt
		try (PrintWriter pw = response.getWriter()) {
			// 3. get req params
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// 4 . invoke dao's method for user auth.
			User user = userDao.authenticateUser(email, password);
			if (user == null)
				pw.print("<h5> Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			else {
				//in the buffer
				pw.print("<h5> Successful Login </h5>");
				pw.print("<h5> User Details " + user + "</h5>");
//				pw.flush();
				// 5. Create a cookie to store user details
				Cookie c1 = new Cookie("user_details", user.toString());
				//6. add the cookie in the resp header
				response.addCookie(c1);
				// 5. role based authorization
				if (user.getRole().equals("admin")) // admin user
					response.sendRedirect("admin_page");
				else // voter user
				{
					if (user.isVotingStatus()) // alrdy voted
						response.sendRedirect("logout");
					else // not yet voted
						response.sendRedirect("candidate_list");
					/*
					 * WC sends temp redirect resp
					 * SC 302 | Location : candidate_list , Set-cookie : user_details : user details
					 * Body : empty
					 */
				}

			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
