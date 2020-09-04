package login.user.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignInRegister
 */
@WebServlet("/SignInRegister")
public class SignInRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.setAttribute("emailid", emailid);
		}
		if(LoginDAO.validate(emailid,password))
		{
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		else
		{
			out.print("<p style=color:red>Sorry username or password error</p>");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		out.close();
	}

}
