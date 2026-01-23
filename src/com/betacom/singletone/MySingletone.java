package com.betacom.singletone;

public class MySingletone {

	private static MySingletone instance = null;
	
	private Integer idx = 0;
	
	private MySingletone() {
	}

	public static MySingletone getInstance() {
		if (instance == null) {
			instance = new MySingletone();
		}
		return instance;
	}
	
	public Integer computeIndice() {
		return ++idx;
	}
}
