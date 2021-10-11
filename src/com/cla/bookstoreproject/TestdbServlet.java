package com.cla.bookstoreproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestdbServlet
 */
@WebServlet("/TestdbServlet")
public class TestdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//Setup Connection Variables
		String user="bookdetail";
		String pass="bookdetail";
		
		String jdbcurl="jdbc:mysql://localhost:3306/db_book_store?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to the database  "+jdbcurl);
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcurl,user,pass);
			out.println("Connecting Successful  ");
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
