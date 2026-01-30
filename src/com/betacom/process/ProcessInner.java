package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Inner;

public class ProcessInner implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessInner");
		Inner inner = new Inner();
		inner.setFatherClass("Siamo nella class Padre");
		inner.setNumero(3);
		
		System.out.println("Class inner :" + inner.getFatherClass() + " numero:" + inner.getNumero());
		
		Inner.Figlio figlio = inner.setInstanceFiglio();
		figlio.setFiglioClass("Sonos nella class figlio");
		figlio.setNumero2(22);
		
		System.out.println("Valore del figlio:" + figlio.displayNumber());
		
		Inner.Figlio.Nipote nipote = figlio.setInstanceNipote();
		nipote.setNumero3(888);
		
		nipote.setNome("aaaa");
		
		System.out.println("Valore del nipote:" + nipote.displayNumberNipote() + " impiegati:" + nipote.getNome());
		
		
		return false;
	}

}
