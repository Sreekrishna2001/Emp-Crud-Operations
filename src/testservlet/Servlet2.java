package testservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

    /**
     * Default constructor. 
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public Servlet2() throws ClassNotFoundException, SQLException {
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
		RequestDispatcher rd2=request.getRequestDispatcher("displayemp.html");
		rd2.include(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
	}

}
