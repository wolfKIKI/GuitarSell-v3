package com.guitarsell3.test;


import java.sql.*;

import com.guitarsell3.util.DBSqlite;

public class DBSqliteTest {
	
	
	//测试sqlite数据库
	
		
		public static void main(String[] args) {
			Connection conn = DBSqlite.getConn();
			Statement stmt=DBSqlite.getStatement(conn);
			String sql = "select * from guitar";
			ResultSet rs=DBSqlite.getResultSet(stmt, sql);
			try {
				rs.last(); // 将光标移动到最后一行     
				int rowCount = rs.getRow(); // 得到当前行号，即结果集记录数  
				System.out.println("有" +rowCount +"个记录");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBSqlite.close(stmt);
			DBSqlite.close(conn);
			
			
		}
	
}
