package com.betacom.process;

import java.util.StringTokenizer;

import com.betacom.interfaces.ProcessInterface;

public class StringProcess implements ProcessInterface{
	
	@Override
	public boolean execute() throws Exception{
		System.out.println("Begin StringProcess");
		String nome = "Gerard";
		StringBuilder  sb = new StringBuilder();
		/*
		 * build della String con append
		 */
		sb.append("Buongiorno");
		sb.append(" , ");
		sb.append("sono ");
		sb.append(nome);
		
		String rS = sb.toString();
		System.out.println(rS);
		
		
		/*
		 * build della String con String.format
		 */
		String n = "Francese";
		String r = String.format("Mio none é %s, e sono %s", nome, n);
		System.out.println(r);
		
		
		if (nome.equalsIgnoreCase("gerard"))
			System.out.println("Found " + nome);
		
		if (rS.contains(","))
			System.out.println("Found comma");
		else
			System.out.println("NOT Found comma");
		
		String test = "      ".trim();
		if (test.isEmpty())
			System.out.println("String vuota");
		
		
		/*
		 * String compare
		 */
		
		String p1 = "Samsung";
		String p2 = "Samsungaaa";
		int result = p2.compareTo(p1);
		
		System.out.println("compare = " + result);
		
		
		/*
		 * transformzione int to string
		 */
		int numero = 20;
		String numeroStr = String.valueOf(numero);
		System.out.println("Numero string:" + numeroStr);
		
		
		/*
		 * transformazione String to  Integer
		 */
		
		numeroStr = "234567";
		numero = Integer.parseInt(numeroStr);
		numero++;
		System.out.println("Valore di numero:" + numero);
		
		
		/*
		 * Transformazione d'una string in array
		 */
		String parameters = "token1,token2, token3,token4,token5,token6,token7 ";
		String[] tokens = parameters.split(",");
		for (String it:tokens) {
			System.out.println(">>" + it.trim() + "<<");
		}
		
		/*
		 * StringTokenizer
		 */
		System.out.println("*** utilizzo di stringtokenizer *****");
		StringTokenizer st = new StringTokenizer(parameters, ",");
		while (st.hasMoreTokens()) {
			String txt = st.nextToken().trim();
			System.out.println(">>" + txt + "<<");
		}
		
		System.out.println(r.substring(r.indexOf("G")));
		System.out.println(r.substring(r.indexOf("G"),r.indexOf(",") ));
		
		String prova = "     questo é un test per il linguaggio ££ , vediamo ££ il risultato";
		String provatR = prova.replace("££", "Java").toUpperCase().trim();
		
		System.out.println(provatR);
		
		
		
		return true;
	}
}
