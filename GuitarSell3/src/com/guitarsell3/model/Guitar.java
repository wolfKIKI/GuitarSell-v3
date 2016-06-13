package com.guitarsell3.model;



public class Guitar {
	private int serialNumber;
	private double price;
	private GuitarSpec spec;
	
	
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber ) {
		this.serialNumber =serialNumber ;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public GuitarSpec getSpec() {
		return spec;
	}
	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
	
}

