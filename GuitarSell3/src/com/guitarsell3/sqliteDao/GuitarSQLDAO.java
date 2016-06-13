package com.guitarsell3.sqliteDao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.guitarsell3.model.*;
import com.guitarsell3.util.DBSqlite;

import com.guitarsell3.dao.GuitarDAO;

public class GuitarSQLDAO implements GuitarDAO {
	
	@Override
	public List<Guitar> getGuitars(){
		Connection conn = DBSqlite.getConn();
		Statement stmt = DBSqlite.getStatement(conn);
		String sql = "select * from guitar";
		ResultSet rs = DBSqlite.getResultSet(stmt, sql);
		List<Guitar> guitars = new ArrayList<Guitar>();
		try {
			while (rs.next()) {
				Guitar g = getGuitarFromRs(rs);
				guitars.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSqlite.close(stmt);
			DBSqlite.close(rs);
			DBSqlite.close(conn);
		}

		return guitars;
	}
	private Guitar getGuitarFromRs(ResultSet rs) {
		Guitar g = null;
		GuitarSpec spec=null;
		try {
			g = new Guitar();
			spec=new GuitarSpec();
			g.setSerialNumber(rs.getInt("serialNumber"));
			spec.setBuilder(Enum.valueOf(Builder.class, rs.getString("builder")));
			spec.setNumStrings(rs.getInt("numstrings"));
			g.setPrice(rs.getDouble("price"));
			spec.setModel(rs.getString("model"));
			spec.setType(Enum.valueOf(Type.class, rs.getString("type")));
			spec.setBackWood(Enum.valueOf(Wood.class, rs.getString("backWood")));
			spec.setTopWood(Enum.valueOf(Wood.class, rs.getString("topWood")));
			g.setSpec(spec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	
	public void add(Guitar g) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBSqlite.getConn();
			String sql = "insert into guitar values (?, ?, ?, ?, ?, ?, ?,?)";
			pstmt = DBSqlite.prepare(conn, sql);
			pstmt.setInt(1, g.getSerialNumber());
			pstmt.setDouble(2, g.getPrice());
			pstmt.setInt(3, g.getSerialNumber());
			pstmt.setString(4, g.getSpec().getBuilder().toString());			
			pstmt.setString(5, g.getSpec().getModel());
			pstmt.setString(6, g.getSpec().getType().toString());
			pstmt.setString(7, g.getSpec().getBackWood().toString());
			pstmt.setString(8, g.getSpec().getTopWood().toString());
			pstmt.executeUpdate();
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSqlite.close(pstmt);
			DBSqlite.close(conn);
		}
	}
	
	
	public void delete(int serialNumber){
		Connection conn=null;
		Statement stmt=null;
		String sql;
		try{
			conn=DBSqlite.getConn();
			sql="delete from guitar where serialNumber=" + serialNumber;
			stmt=DBSqlite.getStatement(conn);
			DBSqlite.executeUpdate(stmt, sql);
			System.out.println("删除成功");
		}finally{
			DBSqlite.close(stmt);
			DBSqlite.close(conn);
		}
	}
}

