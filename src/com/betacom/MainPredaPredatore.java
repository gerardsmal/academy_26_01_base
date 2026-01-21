package com.betacom;

import java.util.ArrayList;

import com.betacom.interfaces.Gazella;
import com.betacom.interfaces.Pesce;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;
import com.betacom.objects.Leone;

public class MainPredaPredatore {

	public static void main(String[] args) {
		System.out.println("Begin MainPredaPredatore");
		ArrayList<Object> lO = new ArrayList<Object>();
		lO.add(new Leone());
		lO.add(new Gazella());
		lO.add(new Pesce());
		lO.add(new Leone());
		
		for (Object obj:lO) {
			identificate( obj);			
		}
	}
	
	
	
	private static void identificate(Object o) {
		if (o instanceof Preda) {
			Preda obj = (Preda)o;
			obj.sonoUnaPreda();
			
		}
		
		if (o instanceof Predatore) {
			Predatore obj = (Predatore)o;
			obj.sonoUnPredatore();		
		}
		
	}

}
