package com.betacom.process;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

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
		
		List<Impiegato> lI = Stream.of(
				new Impiegato("Paolo", "Verdi", true, 1800.00),
				new Impiegato("Pietro", "Bianchi", true, 1900.00),
				new Impiegato("Anna", "Rossi", false, 2000.00),
				new Impiegato("Giuseppe", "Giallo", true, 2100.00),
				new Impiegato("Alex", "Pretty", true, 2200.00),
				new Impiegato("Cristina", "Marrone", false, 2300.00),
				new Impiegato("Ugo", "Blue", true, 2400.00),
				new Impiegato("Maria", "Cancel", false, 2800.00)			
				)
				.collect(Collectors.toList());  // list modificabile
	
		
//		lI.sort(new Comparator<Impiegato>() {
//			@Override
//			public int compare(Impiegato o1, Impiegato o2) {			
//				return Double.compare(o2.getSalary(), o1.getSalary());
//			}
//		});
		
		lI.sort((Impiegato o1, Impiegato o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
		
		lI.forEach(i -> System.out.println(i));
		
		return false;
	}
	
	private void metodo(String param) {
		System.out.println("Azione eseguito con parametro " + param);
		System.out.println("Seconda intruzione..");
		
	}

}
