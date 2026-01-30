package com.betacom.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Address;

public class ProcessSerializzazione implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessSerializzazione");
		
		Address address = new Address();
		address.setCity("Roma");
		address.setName("Vincenzio Rossi");
		address.setSesso(true);
		address.setStreet("Via Torino");
		address.setDesc("Mia descrizione");
		
		
		try {
			FileOutputStream fout = new FileOutputStream("/Users/gerard/Downloads/address.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.flush();
			oos.close();
			System.out.println("Object created...." + address);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
