package com.guitarsell3.test;


import java.sql.*;

import com.guitarsell3.util.DBSqlite;

public class DBSqliteTest {
	
	
	//����sqlite���ݿ�
	
		
		public static void main(String[] args) {
			Connection conn = DBSqlite.getConn();
			Statement stmt=DBSqlite.getStatement(conn);
			String sql = "select * from guitar";
			ResultSet rs=DBSqlite.getResultSet(stmt, sql);
			try {
				rs.last(); // ������ƶ������һ��     
				int rowCount = rs.getRow(); // �õ���ǰ�кţ����������¼��  
				System.out.println("��" +rowCount +"����¼");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBSqlite.close(stmt);
			DBSqlite.close(conn);
			
			
		}
	
}
