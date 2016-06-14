package com.guitarsell3.dao;

import java.sql.*;


public class mysqlDB {
	public static final  String url="";
	public static final String name="com.mysql.jdbc.Driver";
	public static final String user="root";
	public static final String password="";
	
	
	
	public static Connection getConn(){
		Connection c=null;
		try{
			Class.forName(name);//ָ����ѯ����
			c=DriverManager.getConnection(url,user,password);//�������
		}catch (Exception e){
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return c;
		}
	
	
	public static PreparedStatement prepare(Connection conn, String sql){
		PreparedStatement pstmt=null;
		try{
			if(conn !=null){
				pstmt=conn.prepareStatement(sql);//׼��ִ�����
			}
		}catch (SQLException e){
			e.printStackTrace();
			
		}
		return pstmt;
	}
	
	//�ر�����
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
