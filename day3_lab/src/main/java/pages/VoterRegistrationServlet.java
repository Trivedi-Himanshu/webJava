package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
@WebServlet("/VoterRegistrationServlet")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	
	public void init() throws ServletException  {
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("SQLException from "+getClass(),e);
		}
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		response.sendRedirect("voter_registration.html");
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		try(PrintWriter pw= response.getWriter()){
			
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");
			String email = request.getParameter("em");
			String pswd = request.getParameter("pass");
			Date dob=Date.valueOf(request.getParameter("dob"));
			User user = new User(fName, lName, email, pswd,dob);
			//System.out.println(user);
			
			
			userDao.registerNewVoter(user);
			
			//System.out.println(user);
			
			//getting the cookie and saving it into the respose 
			Cookie c1 = new Cookie("User_info", user.toString());
			response.addCookie(c1);
			
			response.sendRedirect("login.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("error occured SQLerror"+getClass(), e);
		}
		
		
	}

}
