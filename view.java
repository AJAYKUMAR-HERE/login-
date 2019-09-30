import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class view extends HttpServlet
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
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
Statement stmt=con.createStatement();
String sql="select * from employee where id=10001";
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
String id=rs.getString("id");
String ename=rs.getString("ename");
String dob=rs.getString("dob");
String age=rs.getString("age");
String gen=rs.getString("gen");
String phoneno=rs.getString("phoneno");
String salary=rs.getString("salary");

out.println("Username: " + id + " <br >");
out.println("password: " + ename  + "<br>"); 
out.println("dateofBirth: " + dob + " <br >");
out.println("Age: " + age + " <br >");
out.println("Gender: " + gen + " <br >");
out.println("Phone Number: " + phoneno + " <br >");
out.println("Salary: " + salary + " <br >");


}
rs.close();
stmt.close();
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
