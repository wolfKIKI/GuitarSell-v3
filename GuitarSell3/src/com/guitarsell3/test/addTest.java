package com.guitarsell3.test;

import com.guitarsell3.model.*;

public class addTest {
	public static void main(String[] args){
		
		Builder builder=Builder.FENDER;
		
		Guitar g=new Guitar();
		GuitarSpec spec=new GuitarSpec();
		g.setSpec(spec);
		spec.setBuilder(builder);
		
		String b=g.getSpec().getBuilder().toString();
		System.out.println(b);
		
	}

}
