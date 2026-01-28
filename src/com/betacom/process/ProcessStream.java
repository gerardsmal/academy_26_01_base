package com.betacom.process;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

public class ProcessStream implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessStream");
		/*
		 * Create list with Stream
		 */
		List<Impiegato> lI = Stream.of(
				new Impiegato("Paolo", "Verdi", true, 1800.00),
				new Impiegato("Pietro", "Verdi", true, 1800.00),
				new Impiegato("Anna", "Verdi", true, 1800.00),
				new Impiegato("Giuseppe", "Verdi", true, 1800.00),
				new Impiegato("Alex", "Verdi", true, 1800.00),
				new Impiegato("Cristina", "Verdi", true, 1800.00),
				new Impiegato("Ugo", "Verdi", true, 1800.00),
				new Impiegato("Paolo", "Verdi", true, 1800.00)			
				)
				.toList();
		
		lI.forEach(imp -> System.out.println(imp));
		
		/*
		 * create Strem with builder
		 */
		
		Stream<String> streamBuilder = Stream.<String> builder()
				.add("lunedi")
				.add("martedi")
				.add("mercoledi")
				.add("giovedi")
				.add("venerdi")
				.add("sabato")
				.add("domenica")
				.build();
		
		String[] giorni = streamBuilder.toArray(size -> new String[size]);
		System.out.println("giorni length:" + giorni.length + " giorni[4]:" + giorni[4]);
		
		
		
		
		return false;
	}

}
