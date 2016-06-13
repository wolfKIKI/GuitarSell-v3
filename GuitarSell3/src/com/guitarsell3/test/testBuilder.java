package com.guitarsell3.test;



import com.guitarsell3.model.Builder;

public class testBuilder {
	
	public static void main(String[] args) {
		
		
		if((Builder.FENDER).equals(Enum.valueOf(Builder.class, "FENDER"))){
			System.out.println("true");
		}else{
			System.out.println("flase");
		}
	}
}