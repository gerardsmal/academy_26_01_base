package com.betacom;

import com.betacom.objects.Impiegato;
import com.betacom.objects.User;

public class MainEredit {

	public static void main(String[] args) {
		System.out.println("Begin MainEredit");
		Impiegato imp = new Impiegato("Gianni","Laverdura", true, 1500.0);
		
		System.out.println(imp);
		
		imp = new Impiegato();
		imp.setCognome("Bianco");
		imp.setNome("Bruno");
		imp.setSesso(true);
		imp.setSalary(1300.00);
		
		System.out.println(imp);
		
		System.out.println(imp.getSesso());
		
		User a = new User();
		
		
	}

}
