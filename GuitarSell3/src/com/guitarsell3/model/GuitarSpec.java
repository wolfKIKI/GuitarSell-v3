package com.guitarsell3.model;

public class GuitarSpec {
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int numStrings;
	
	 
	public Builder getBuilder() {
		return builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Wood getBackWood() {
		return backWood;
	}
	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}
	public Wood getTopWood() {
		return topWood;
	}
	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}
	public int getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}
	public boolean matches(GuitarSpec otherSpec,Guitar guitar){
		if (guitar.getSpec().getBuilder() !=otherSpec.getBuilder())
			return false;
		String model = guitar.getSpec().getModel().toLowerCase();
		if((model!=null) && (!model.equals("")) && (!model.equals(otherSpec.getModel().toLowerCase())))
			return false;
		if (guitar.getSpec().getType() !=otherSpec.getType())
			return false;
		if(guitar.getSpec().getNumStrings() !=otherSpec.getNumStrings())
			return false;
		if(guitar.getSpec().getBackWood()!=otherSpec.getBackWood())
			return false;
		if(guitar.getSpec().getTopWood() !=otherSpec.getTopWood())
			return false;
		return true;
					
	}
}
