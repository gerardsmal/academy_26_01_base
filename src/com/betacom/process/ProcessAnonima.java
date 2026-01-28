package com.betacom.process;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.ProcessInterface;

public class ProcessAnonima implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessAnonima");
		
		Azione a = new Azione() {
			
			@Override
			public void esegui(String param) {
				System.out.println("Azione eseguito con parametro " + param);
				
			}
		};
		
		a.esegui("mio parametro");
		
		/*
		 * transformazione in lambda 
		 */
		
		Azione l = (param) -> metodo(param);

	
		l.esegui("parametro");	
		
		
		
		return false;
	}
	
	private void metodo(String param) {
		System.out.println("Azione eseguito con parametro " + param);
		System.out.println("Seconda intruzione..");
		
	}

}
