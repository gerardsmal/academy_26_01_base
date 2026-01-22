package com.betacom.process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.betacom.enums.Reparto;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

public class ProcessCollection implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessCollection");
		executeList();
		return false;
	}
	
	private void executeList() {
		List<Impiegato> lI = new ArrayList<Impiegato>();
		
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
		
		listImpiegati(lI, "Dopo creazione");
		
		Impiegato save = removeFromImpiegato(5, lI);

		listImpiegati(lI, "Dopo remove con pos");
		
		if (save != null) {
			lI.add(save);
			listImpiegati(lI, "Dopo restore item cancelato");
		}
		
		save = removeFromImpiegato("Billico", lI);
		listImpiegati(lI, "Dopo creazione con cognome");
		if (save == null) {
			System.out.println("errore nella cancellazione");
		}
		
		lI = increaseSalary(1.5, "IT", lI);
		listImpiegati(lI, "Dopo increaseSalary");

		sortBySalary(lI);
		listImpiegati(lI, "Dopo sort");
		
		
	}
	private void sortBySalary(List<Impiegato> lI) {
		lI.sort(new Comparator<Impiegato>() {
			@Override
			public int compare(Impiegato o1, Impiegato o2) {			
				return Double.compare(o2.getSalary(), o1.getSalary());
			}
		});
		
	}
	
	private void listImpiegati(List<Impiegato> lI, String title) {
		System.out.println("****** " + title + "*****" );
		int pos=0;
		for (Impiegato it:lI) {
			System.out.println(pos + " " + it);
			pos++;
		}		
	}
	
	private Impiegato removeFromImpiegato(int pos, List<Impiegato> lI) {
		Impiegato res = null;
		if (pos >= lI.size()) {
			System.out.println("pos invalido:" + pos + " max:" + lI.size());
		} else {
			res = lI.get(pos);
			lI.remove(pos);		
		}
		return res;
		
	}

	private Impiegato removeFromImpiegato(String cognome, List<Impiegato> lI) {
		int pos = 0;
		for (Impiegato it:lI) {
			if (it.getCognome().equalsIgnoreCase(cognome)) {
				return removeFromImpiegato(pos, lI);
			}
			pos++;
		}
		return null;
	}

	private List<Impiegato> increaseSalary(double d, String reparto, List<Impiegato> lI) {
		Reparto rep = Reparto.valueOf(reparto);
		for (Impiegato it:lI) {
			if (it.getReparto() == rep) {
				it.setSalary(it.getSalary() * d);
			}			
		}
		return lI;
		
	}
	
}
