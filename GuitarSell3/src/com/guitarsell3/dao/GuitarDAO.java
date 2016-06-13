package com.guitarsell3.dao;

import java.util.List;

import com.guitarsell3.model.Guitar;



public interface GuitarDAO {
	
	public List<Guitar> getGuitars();
	public void add(Guitar g);
	public void delete(int serialNumber);
	
	
}
