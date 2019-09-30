import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class delete extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException
{
 String JDBC_DRIVER="com.mysql.jdbc.Driver";
 String DB_URL="jdbc:mysql://localhost:3306/employeedetails";

String USER="root";
String PASS="ajaykumar";
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String title="Database result"; 
String id=request.getParameter("id");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
PreparedStatement pst = con.prepareStatement("delete from employee where id =?");
pst.setString(1,id);
pst.executeUpdate();
out.println("Data Deleted suceefully");
pst.close();
con.close();
}
catch(SQLException se)
{
  se.printStackTrace();
}
 catch(Exception e)
{
 e.printStackTrace();
    }
  }
}