package com.betacom.process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.betacom.enums.Reparto;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

public class ProcessCollection implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessCollection");
		executeList();
		executeMap();
		mapTest();
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
	
	private void executeMap() {
		System.out.println("Map process...");
		String value = null;
		String keySearch = null;
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "v10");
		
		System.out.println("Numero elementi Map:" + map.size());
		
		keySearch="k70";
		if (map.containsKey(keySearch)) {
			value = map.get(keySearch);
			System.out.println("Valore di " + keySearch  +":" + value);			
		} else {
			System.out.println("la chiave " + keySearch  +" non trovata.");
		}
		
		value = "v5";
		if (map.containsValue(value)) {
			System.out.println("Valore " + value  +" trovato.");			
		} else {
			System.out.println("Valore " + value  +" NON trovato.");		
		}
		
		map.put("k3", "k3 modificata");		
		System.out.println("Valore di k3:" + map.get("k3"));

		value = "k3";
		if (map.containsValue(value)) {
			System.out.println("Valore " + value  +" trovato.");			
		} else {
			System.out.println("Valore " + value  +" NON trovato.");		
		}
		System.out.println("List map with Entry");
		for (Entry<String, String> it:map.entrySet()) {
			System.out.println("key:" + it.getKey() + " value:" + it.getValue());
		}
		
		System.out.println("List map with KeySet");
		for (String it:map.keySet()) {
			System.out.println("key:" + it + " value:" + map.get(it));
		}
		

	}
	
	private void mapTest() {
		String params = "p1=aaa,p2=BBB,p3=26,p4=Paolo";
		System.out.println("Valore di params:" + params);
		String[] p = params.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String it:p) {
			String[] elem = it.split("=");
			map.put(elem[0],elem[1]);
		}

		System.out.println("List map with KeySet");
		for (String it:map.keySet()) {
			System.out.println("key:" + it + " value:" + map.get(it));
		}

		List<String> input = new ArrayList<String>();
		input.add( "p1=aaa,p2=BBB,p3=26,p4=Paolo");
		input.add( "par1=10,par2=param2,par3=20.0, par4 =SAS");
		input.add( "k1=Terzo,k2= 50,k3=struccutura,k4=50%, k6=aaa");
		input.add( "p1=22,p2= Quarto,p3 = ABC,p4=20.5");

		System.out.println("Build map");
		List<Map<String, String>> res = new ArrayList<Map<String,String>>();
		for (String inp:input) {
			String[] par1 = inp.split(",");
			Map<String, String> colum = new HashMap<String, String>();
			for (String it:par1) {
				String[] elem = it.split("=");
				colum.put(elem[0].trim(),elem[1].trim());
			}
			res.add(colum);
		}
		System.out.println("Risultato .....");
		int i = 0;
		for (Map<String,String> it:res) {
			System.out.println("riga " + ++i +":" + it.size());
			for (String el:it.keySet()) {
				System.out.println("key:" + el + " value:" + it.get(el));
			}
			
		}
		
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
