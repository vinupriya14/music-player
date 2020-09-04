package login.user.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginRegister() {
    	super();
    }
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		Customer c=new Customer();
		c.setName(name);
		c.setPassword(password);
		c.setEmailid(email);
		c.setPhonenumber(phonenumber);
		CustomerDAOimp  customerDAO=new CustomerDAOimp();
		String userRegistered=customerDAO.registerUser(c);
		if(userRegistered.equals("SUCCESS"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errorMessage", userRegistered);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
				
		
	}

}
