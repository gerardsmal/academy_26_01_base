package com.betacom.objects;

import com.betacom.interfaces.SampleInterface;
import com.betacom.interfaces.SampleInterface1;

public class ClassInterface implements SampleInterface , SampleInterface1{

	@Override
	public void interface1(String p) {
		System.out.println("implementation intercace1 da ClassInterface p:" + p);
		
	}

	@Override
	public void interface2(String p) {
		System.out.println("implementation interface 2  ClassInterface p:" + p);
		
	}

	@Override
	public void test1(String t1) {
		System.out.println("implementation test 1  da ClassInterface p:" + t1);
		
	}

	@Override
	public void test2(String t2) {
		System.out.println("implementation test 2  da ClassInterface p:" + t2);
		
	}

}
