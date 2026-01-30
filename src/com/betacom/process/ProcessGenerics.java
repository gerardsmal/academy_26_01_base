package com.betacom.process;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.GenericResponse;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;
import com.betacom.objects.User;

public class ProcessGenerics implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessGenerics");
		
		List<Impiegato> lI = Stream.of(
				new Impiegato("Paolo", "Rossi", true, 2000.00),
				new Impiegato("Pietro", "Verde", true, 1300.00),
				new Impiegato("Anna", "Giallo", false, 1500.00),
				new Impiegato("Giuseppe", "Nero", true, 1800.00),
				new Impiegato("Alex", "Bianco", true, 1400.00),
				new Impiegato("Cristina", "Griggio", false, 1600.00),
				new Impiegato("Ugo", "Blu", true, 1200.00),
				new Impiegato("Maria", "Pastel", false, 1900.00)
				).collect(Collectors.toList());
		
		GenericResponse<Impiegato, String> resp = new GenericResponse<Impiegato, String>();
		resp.setRc(true);
		resp.setMsg("Operazione eseguita");
		resp.setData(lI);
		
		System.out.println(resp);
		
		List<User> lU = List.of(
				new User("Paolo", "Berat", "M", 2000, 2, 6),
				new User("Anna", "Bella", "F", 2006, 5, 9),
				new User("Gianni", "Laverdura", "M", 1998, 8, 14),
				new User("Maria", "Angela", "F", 2001, 5, 1)				
				);
		
		ImpiegatoStream imS = new ImpiegatoStream("tes1", "test2");
		
		
		GenericResponse<User, ImpiegatoStream> resp1 = new GenericResponse<User, ImpiegatoStream>();
		resp1.setRc(true);
		resp1.setMsg(imS);
		resp1.setData(lU);
		
		System.out.println(resp1);
		
		return false;
	}

}
