package com.guitarsell3.dao;

public class dataAccess {
	
	private static String daoName = "sqliteDao";
	//private static String daoName = "mysqlDao";
	public static GuitarDAO createGuitarDao() {
		GuitarDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "GuitarSQLDAO").newInstance();
			result = (GuitarDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
