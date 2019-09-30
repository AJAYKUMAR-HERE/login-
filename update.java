import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class update extends HttpServlet
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
String query = "update employee set id='"+id+"',ename='"+ename+"',dob='"+dob+"',age='"+age+"',gen='"+gen+"',phoneno='"+phoneno+"',salary='"+salary+"' where id="+id;
Statement stmt = con.createStatement();
int i = stmt.executeUpdate(query);
out.println("update successfully");
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
