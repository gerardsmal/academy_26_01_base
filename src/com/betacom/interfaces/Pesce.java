package com.betacom.interfaces;

public class Pesce implements Preda, Predatore{

	@Override
	public void sonoUnaPreda() {
		System.out.println("Sono un piccolo pesce e sono una preda..");
		
	}

	@Override
	public void sonoUnPredatore() {
		System.out.println("Sono un grosso pesce e sono un predatore");
		
	}

}
