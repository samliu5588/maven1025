

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import model.Employee;
/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Employee> list=create();
         request.setAttribute("employees", list);
         request.getRequestDispatcher("empView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	List<Employee> create(){
		List<Employee> temp=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/classicmodels";
		String user="root";
		String password="Sm558862";
		String sql="select * from classicmodels.employees";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,user,password);
	        Statement st=cn.createStatement();
	        ResultSet rs=st.executeQuery(sql);
	        while(rs.next()) {
	        	int n=rs.getInt("employeeNumber");
	        	String fn=rs.getString("firstName");
	        	String ln=rs.getString("lastName");
	        	String ex=rs.getString("extension");
	        	String em=rs.getString("email");
	        	int rt=rs.getInt("reportsTo");
	        	String job=rs.getString("jobTitle");
	        	String code=rs.getString("officeCode");
	        	Employee emp=new Employee(n,fn,ln,ex,em,job,code,rt);
	        	temp.add(emp);
	        }
	        cn.close();
		}catch(SQLException|ClassNotFoundException ex) {
			System.out.println("SQL Error:"+ex.getMessage());
		 	
		}		
		return temp;
	}
}
