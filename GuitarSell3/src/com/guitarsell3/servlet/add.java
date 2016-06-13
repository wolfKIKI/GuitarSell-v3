package com.guitarsell3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitarsell3.dao.GuitarDAO;
import com.guitarsell3.dao.dataAccess;
import com.guitarsell3.model.Builder;
import com.guitarsell3.model.Guitar;
import com.guitarsell3.model.GuitarSpec;
import com.guitarsell3.model.Type;
import com.guitarsell3.model.Wood;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Guitar g=new Guitar();
		GuitarSpec spec=new GuitarSpec();
		spec.setBackWood(Enum.valueOf(Wood.class,request.getParameter("backWood")));
		spec.setBuilder(Enum.valueOf(Builder.class,request.getParameter("builder")));
		spec.setModel(request.getParameter("model"));
		spec.setTopWood(Enum.valueOf(Wood.class,request.getParameter("topWood")));
		spec.setType(Enum.valueOf(Type.class,request.getParameter("type")));
		g.setSpec(spec);
		//获取系列号和价格
		int serialNumber=Integer.parseInt(request.getParameter("serialNumber"));
		double price= Double.valueOf(request.getParameter("price"));
		g.setSerialNumber(serialNumber);
		g.setPrice(price);
		GuitarDAO dao = dataAccess.createGuitarDao();
		dao.add(g);		

 	 	request.getRequestDispatcher("GuitarList").forward(request, response);
	}
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
