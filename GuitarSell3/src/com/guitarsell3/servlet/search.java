package com.guitarsell3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitarsell3.dao.GuitarDAO;
import com.guitarsell3.dao.dataAccess;
import com.guitarsell3.model.*;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
    	String builder=request.getParameter("builder");
    	int numstrings=Integer.parseInt(request.getParameter("numstrings"));
    	String model=request.getParameter("model");
    	String type=request.getParameter("type");
    	String topWood=request.getParameter("topWood");
    	String backWood=request.getParameter("backWood");
    	
    	//封装用户想要的guitar
    	
    	GuitarSpec guitarWanted=new GuitarSpec();
    	
    	guitarWanted.setBuilder(Enum.valueOf(Builder.class, builder));
    	guitarWanted.setModel(model);
    	guitarWanted.setNumStrings(numstrings);
    	guitarWanted.setType(Enum.valueOf(Type.class, type));
    	guitarWanted.setTopWood(Enum.valueOf(Wood.class, topWood));
    	guitarWanted.setBackWood(Enum.valueOf(Wood.class, backWood));
    	//搜索符合条件的吉他
    	
    	
    	Inventory inventory=new Inventory();
    	List<Guitar> matchingGuitars=inventory.search(guitarWanted);
    	request.setAttribute("matches", matchingGuitars);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
