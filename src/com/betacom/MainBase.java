package com.betacom;
import java.util.ArrayList;
import java.util.Scanner;

import com.betacom.objects.User;
import com.betacom.utils.PromozioneAutomatica;

public class MainBase {

	public static void main(String[] args) {
		/*
		 * primitive
		 * nome        bit    byte         range valori
		 * byte        8      1            -128 +127
		 * int         32     4            + p - 2*10 ^9
		 * short       16     2            -32768 +32767
		 * long        64     8            + o - 9*10 ^18
		 * float       32     4 
		 * double      64     8
		 */
		byte b = 127;           // Byte
		int i = 2_000_000_000; // Integer
		short s = 32767;       // Short
		long j = 9_473_892_479_237L; // Long
		char c = 'z';            // Character
		boolean bool = true;    // Boolean
		double d = 123;
		
		/*
		 * reference
		 */
		String str = "Ciao sono una string";
		
		System.out.print(str + "\n");
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("nome:");
//		String nome = sc.nextLine();
//		System.out.println("Valore di nome:" + nome.toUpperCase());
		
		/*
		 * operatori logici
		 * ! not
		 * && and
		 * || or
		 * < > <= >=
		 */
		char p3 = 'z';
		int p1 = 30;
		int p2 = 16;
		boolean rc = (p1 > p2) && (p3 != 'p');
		System.out.println("valore di rc:" + rc);
		
		int eta = 40;
		String result = "";
		if (eta < 30) 
			result = "Sei un ragazzino";
		 else 
			result = "Non sei un ragazzino";

		
		System.out.println(result);
		// ternary expression

		result = (eta < 30) ? "Sei un ragazzino (op ternary)" : "Non sei un ragazzino (op ternary)";
		System.out.println(result);
		
		
		/*
		 * operatori aritmetici
		 * + - / * %
		 */
		
		i = 20;
		i++;
		int jj = 3;
		int res = i * jj;
		int div = res / 2;
		int rim = res % 2;
		
		System.out.println("Valore di i:" + i
				 + " res:" + res
				 + " div:" + div
				 + " rim:" +  rim);
		
		String param = "123456";
		i = Integer.parseInt(param);
		System.out.println("Conversione string to int:" + param);
		
		param = "alkldklkdolfekwkoeefmfekoekdodfioskkor";
		System.out.println("length param:" + param.length()
				+ " part of string:" + param.substring(4,6));
		
		param = "      inizo     corso di Java      ";
		System.out.println(">>>" +param.trim() + "<<<<<");
		
		String search = "corso";
		if (param.trim().contains(search))
			System.out.println(search + " trovato dentro la string");
		else
			System.out.println(search + " NON trovato dentro la string");
		
		if ("CORSO".equalsIgnoreCase(search))
			System.out.println("parametro corso found");
		
		
		String[] array = {"primo", "secondo", "terzo", "quarto"};
		
		array[1] = "modificato";
		
		for (int idx=0; idx < array.length; idx++) {
			System.out.println("idx:" + idx + " valore:" + array[idx]);
		}

		for (String it:array) {
			System.out.println(it);
		}
		
		Integer[] numeri = {PromozioneAutomatica.MAX_USER , null, 30, 40, 50};
		for (Integer it:numeri)
			System.out.println(it);
		
		String[] [] multi = new String[3] [4];
		
		/*
		 * Array 2d
		 */
		for (int id=0; id < multi.length; id++) {
			for (int jd = 0; jd < multi[id].length; jd++) {
				multi[id] [jd] = "prova_" + id + "_" +jd;
				// System.out.println("id:" + id + " jd:" + jd);
			}
		}
		System.out.println("id 2 , jd 3:" + multi[1] [3]);
		
		/*
		 * array dinamiche
		 */
		ArrayList<String> aL = new ArrayList<String>();
		aL.add("Pitro");
		aL.add("Paolo");
		aL.add("Pink");
		aL.add("Pallino"); 

		
		System.out.println("Length:" + aL.size());
		
		aL.add("Berta");
		
		for (String it:aL) {
			System.out.println(it);
		}
		
		System.out.println("al[3]:" + aL.get(3));
		aL.remove(3);

		for (String it:aL) {
			System.out.println(it);
		}

		User aa = new User("test", "promozione", true);
		
		ArrayList<User> lU = new ArrayList<User>();
		lU.add(new User("Piero","Ilgrande", "M"));
		lU.add(new User("Paolo","Rosso", true));
		lU.add(new User("Anna","Verde", "F"));
		lU.add(new User("GianLuca","Giallo", true));
		lU.add(new User("Maria","Nero", false));
		lU.add(new User("Enrico","Grigio", "M"));
		
		/*
		 * list fino raggiungamente d'un cognome 
		 * 
		 */
		
		search = "giallo";
		
		for (User it:lU) {
			System.out.println(it);
			if (search.equalsIgnoreCase(it.getCognome()))
				break;
		}
		
		PromozioneAutomatica.method(10);
		PromozioneAutomatica.method(2.0f);
		PromozioneAutomatica.method("aaaaa");
		PromozioneAutomatica.method(aa);
		
	}

}
