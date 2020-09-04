package login.user.registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CustomerDAOimp {
	public String registerUser(Customer c)
	{
		String name=c.getName();
		String password=c.getPassword();
		String emailid=c.getEmailid();
		String phonenumber=c.getPhonenumber();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			con= MyConnectionProvider.getCon();
			String query="insert into customer(SI_NO,Name,Password,EmailId,PhoneNumber)values(NULL,?,?,?,?)";
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3,emailid);
			preparedStatement.setString(4,phonenumber);
			int i=preparedStatement.executeUpdate();
			if(i!=0)
			{
				return "SUCCESS";
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "OOPS....Something went Wrong";
	}
	
}
