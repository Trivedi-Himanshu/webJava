package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet 
//Key : /hello
//Val : pages.HelloWorldServlet
{
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse resp) throws ServletException,IOException
	{
		System.out.println("in do-get123 "+Thread.currentThread());//nm,prio,grp
		//steps 1. set resp content type , to inform web client
		//API of HttpServletResponse
		//public void setContentType(String contentType)
		resp.setContentType("text/html");
		//2. Get the java.io.PrintWriter , to send the char , buffered resp to the clnt
		//API of HttpServletResponse
		//public PrintWriter getWriter() throws IOException
		try(PrintWriter pw=resp.getWriter()) {
			//3 write the resp , in the resp buffer
			pw.print("<h5>Welcome 2 Servlets .... @ "
			+LocalDateTime.now()+"</h5>");
		}//pw.close() --> adds resp buffer contents(resp body) to the resp pkt
		//Resp pkt : Resp status code , resp header/s , resp body	
	}

}
