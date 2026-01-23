package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.other.CallSingletone;
import com.betacom.singletone.MySingletone;

public class ProcessSingleTone implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessSingleTone");
		
		Integer idx = MySingletone.getInstance().computeIndice();
		
		System.out.println("Valore indice:" + idx);
		
		new CallSingletone().test();
		
		System.out.println("Valore indice chiamato di nuovo:" + MySingletone.getInstance().computeIndice());
		
		return false;
	}

}
