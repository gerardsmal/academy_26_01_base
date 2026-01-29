package com.betacom.process;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;

public class ProcessStream implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessStream");
		/*
		 * Create list with Stream
		 */
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
		
		String[] giorni = streamBuilder.toArray(size -> new String[size]);  // WARNING il stream puo essere utilizzato solo una volta
		System.out.println("giorni length:" + giorni.length + " giorni[4]:" + giorni[4]);
		
		/*
		 * creazione random
		 */
		
		Random ran = new Random();
		Stream<Long> sR = Stream.generate(() -> ran.nextLong()).limit(10);
		sR.forEach(n -> System.out.println(n));
		
		/*
		 * Generazione dati primitive
		 */
		System.out.println("Generazione interi con range");
		IntStream intStream = IntStream.range(3, 15);
		intStream.forEach(i -> System.out.println(i));
		
		/*
		 * Filtro usando stream
		 */
		lI.stream()
			.filter(im -> im.getSesso())
			.filter(im -> im.getSalary() >= 2000.00)
			.forEach(im -> System.out.println(im));
		
		/*
		 * map
		 */
		System.out.println("map");
		List<ImpiegatoStream> lIs = lI.stream()
				.filter(im -> im.getSesso())
				.filter(im -> im.getSalary() >= 2000.00)
				.map(imp -> new ImpiegatoStream(imp.getNome(), imp.getCognome()))
				.toList();
		
		lIs.forEach(i -> System.out.println(i));
		
		
		/*
		 * Count
		 */
		System.out.println("count");
		long count = lI.stream()
				.filter(im -> im.getSesso())
				.count();
		
		System.out.println("Numero di maschi:" + count);
		
		
		/*
		 * match
		 */
		
		boolean rc = lI.stream()
				.filter(im -> !im.getSesso())
				.anyMatch(im -> im.getSalary() >= 2500.00);
		
		System.out.println("Result del match:" + rc);
		
		return false;
	}

}
