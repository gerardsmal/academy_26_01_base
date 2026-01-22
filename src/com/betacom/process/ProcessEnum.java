package com.betacom.process;

import java.util.ArrayList;

import com.betacom.enums.Reparto;
import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

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
		
		
		Impiegato imp = new Impiegato("Giancarlo", "Bolluci", true, 1500.0, "AA");
		System.out.println(imp);
		
		ArrayList<Impiegato> lI = new ArrayList<Impiegato>();
		lI.add(new Impiegato("Giancarlo", "Bolluci", true, 1500.0, "IT"));
		lI.add(new Impiegato("Marco", "Lavulla", true, 1600.0, "IT"));
		lI.add(new Impiegato("Gianni", "Danco", true, 1700.0, "PRODUZIONE"));
		lI.add(new Impiegato("Anna", "Bella", false, 1300.0, "LOGISTICA"));
		lI.add(new Impiegato("Beatice", "Bolluna", false, 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Marco", "Grande", true, 2000.0, "IT"));
		lI.add(new Impiegato("Mirko", "Pulico", true, 1800.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniel", "Andorua", true, 1500.0, "LOGISTICA"));
		lI.add(new Impiegato("Nicolo", "Danke", true, 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniela", "Ciamplu", false, 1900.0, "IT"));
		lI.add(new Impiegato("Angelina", "Billico", false, 2100.0, "LOGISTICA"));
		lI.add(new Impiegato("Eric", "Lapiero", true, 1100.0, "PRODUZIONE"));
		lI.add(new Impiegato("Piero", "Ponte", true, 1500.0, "IT"));
		lI.add(new Impiegato("Maria", "Filippo", false, 1600.0, "LOGISTICA"));
		
		
		String search = "IT";
		
		for (Impiegato im:lI) {
			if (im.getReparto().toString().equals(search))
				System.out.println(im);
		}
		
		
		return false;
	}

}
