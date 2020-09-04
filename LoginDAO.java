package login.user.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
     public static boolean validate(String emailid,String password)
     {
    	 boolean status=false;
    	 Connection connection=null;
    	 PreparedStatement preparedStatement=null;
    	 ResultSet resultSet=null;
    	 try {
    		 connection=MyConnectionProvider.getCon();
    		 preparedStatement=connection.prepareStatement("select * from customer where EmailId=? and Password=?");
    		 preparedStatement.setString(1,emailid);
    		 preparedStatement.setString(2,password);
    		 
    		 resultSet=preparedStatement.executeQuery();
    		 status=resultSet.next();
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }finally {
    		 if(connection!=null)
    		 {
    			 try {
    				 connection.close();
    			 }catch(Exception e)
    			 {
    				 e.printStackTrace();
    			 }
    		 }
    		 if(preparedStatement!=null)
    		 {
    			 try {
    				 preparedStatement.close();
    			 }catch(SQLException e)
    			 {
    				 e.printStackTrace();
    			 }
    		 }
    		 if(resultSet!=null)
    		 {
    			 try {
    				 resultSet.close();
    			 }catch(SQLException e)
    			 {
    				 e.printStackTrace();
    			 }
    		 }
    	 }
		return status;
    	 
     }
}
