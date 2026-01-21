package com.betacom.objects;

import com.betacom.interfaces.SampleInterface1;

public class ClasseInterface1 implements SampleInterface1{

	@Override
	public void test1(String t1) {
		System.out.println("execute test 1 da ClasseInterface1 p:" + t1);
		
	}

	@Override
	public void test2(String t2) {
		System.out.println("execute test 2 ClasseInterface1 p:" + t2);
		
	}

}
