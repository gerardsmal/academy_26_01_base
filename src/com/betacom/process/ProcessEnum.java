package com.betacom.process;

import com.betacom.enums.Reparto;
import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;

public class ProcessEnum implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin process ENUM");
		
		String valore = "PRODUZIONE";
		Reparto reparto = null;
		try {
			reparto = Reparto.valueOf(valore);  // valueOf --par caricare			
			System.out.println("Reaprto:" + reparto.toString());
			
		} catch (IllegalArgumentException e) {
			throw new AcademyException(e.getMessage());
		}
		
		
		
		return false;
	}

}
