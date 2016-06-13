package com.guitarsell3.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.guitarsell3.dao.GuitarDAO;
import com.guitarsell3.sqliteDao.GuitarSQLDAO;



public class Inventory {
	/*
	 private List guitars;
	public Inventory(){ 
		guitars=new LinkedList();
	}
	
	**/
	/**
	public void addGuitar(int serialNumber,double price,String builder,String model,String type,String backWood,String topWood){
		List<Guitar> guitars=new LinkedList();
		Guitar guitar=new Guitar();
		guitar.getSpec();
		guitar.setSerialNumber(serialNumber);
		guitar.setPrice(price);
		guitar.setModel(model);
		guitar.setBuilder(builder);
		guitar.setBackWood(backWood);
		guitar.setTopWood(topWood);
		guitar.setType(type);
		
		guitars.add(guitar);
	}
	*/
	public Guitar getGuitar(int serialNumber){
		List<Guitar> guitars=new LinkedList();
		for (Iterator i=guitars.iterator();i.hasNext();){
			Guitar guitar=(Guitar)i.next();
			if (guitar.getSerialNumber()==serialNumber){
				return guitar;
			}
		}
		return null;
	}
	/**
	public Guitar search(Guitar searchGuitar){
		List<Guitar> guitars=new LinkedList();
		guitars=GuitarMgr.getInstance().getGuitars();
		for(Iterator i=guitars.iterator();i.hasNext();){
			Guitar guitar=(Guitar)i.next();
			String builder=searchGuitar.getBuilder();
			if ((builder!=null) && (!builder.equals("")) && (!builder.equals(guitar.getBuilder())))
				continue;
			String model=searchGuitar.getModel();
			if((model!=null) && (!model.equals("")) && (!model.equals(guitar.getModel())))
				continue;
			String type=searchGuitar.getType();
			if((type!=null) && (!type.equals("")) && (!type.equals(guitar.getType())))
				continue;
			String backWood=searchGuitar.getBackWood();
			if((backWood!=null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBackWood())))
				continue;
			String topWood=searchGuitar.getTopWood();
			if ((topWood!=null) && (!topWood.equals("")) && (!topWood.equals(guitar.getTopWood())))
				continue;
			return guitar;
		}
		return null;
	}
	*/
	public List search(GuitarSpec searchSpec){
		List matchingGuitars = new LinkedList();
		List<Guitar> guitars=new LinkedList();
		GuitarDAO dao=new GuitarSQLDAO();
		guitars=dao.getGuitars();
		for(Iterator i =guitars.iterator();i.hasNext();){
			Guitar guitar =(Guitar)i.next();
			if(guitar.getSpec().matches(searchSpec,guitar))
				matchingGuitars.add(guitar);
				
		}
		return matchingGuitars;	
	}
}
