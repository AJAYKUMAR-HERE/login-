import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Register extends HttpServlet
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
String ename=request.getParameter("ename");
String dob=request.getParameter("dob");
String age=request.getParameter("age");
String gen=request.getParameter("gen");
String phoneno=request.getParameter("phoneno");
String salary=request.getParameter("salary");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
pstmt.setString(1, id);
pstmt.setString(2, ename);
pstmt.setString(3, dob);
pstmt.setString(4, age);
pstmt.setString(5, gen);
pstmt.setString(6, phoneno);
pstmt.setString(7, salary);
int a=pstmt.executeUpdate();
if(a>0) {
out.println("Values Are Inserted");
} else {
out.println("Values Are not Inserted");
}
pstmt.close();
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
