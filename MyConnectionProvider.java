package login.user.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MyConnectionProvider {
    public static Connection getCon()
    {
    	Connection con=null;
    	String url="jdbc:mysql://localhost:3306/music";
    	String username="root";
    	String password="Vicky@2825";
    	try {
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		con=DriverManager.getConnection(url,username,password);
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return con;
    }
}
