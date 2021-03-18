package testservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @throws Exception 
     */
	private Connection con;
    public Servlet1() throws Exception {
        // TODO Auto-generated constructor stub
 		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/flask";
    	System.out.println("Connecting to MySQL...");
    	this.con=DriverManager.getConnection(url,"root","kittu2001");
    	System.out.println("Connected to m MySQL\n");
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out=new PrintWi
		
//		response.getWriter().append("<html>Empname<input name='empname'/><br>Empage:<input name='empage'/><br>EmpSalary:<input name='empsal'/></html>"
//				+ "<button></button>");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		rd.include(request, response);
//		response.getWriter().append("hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empage=request.getParameter("empage");
		try {
//			Statement st=this.con.createStatement();
			PreparedStatement st=this.con.prepareStatement("insert into emp values(?,?,?)");
			st.setString(1, empid);
			st.setString(2, empname);
			st.setString(3, empage);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Submitted Successfully");
	}

}
