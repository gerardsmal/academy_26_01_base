package com.betacom;

import java.util.Scanner;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.process.ProcessAnonima;
import com.betacom.process.ProcessCollection;
import com.betacom.process.ProcessDate;
import com.betacom.process.ProcessEnum;
import com.betacom.process.ProcessException;
import com.betacom.process.ProcessInt;
import com.betacom.process.ProcessSequential;
import com.betacom.process.ProcessSingleTone;
import com.betacom.process.ProcessStream;
import com.betacom.process.StringProcess;

import java.util.HashMap;
import java.util.Map;

public class MainProcess {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Introdure un parametro [interface,string,exception, date, enum, collection, singletone, sequential, anonima, stream]:");
//		String inp = sc.nextLine();
		String inp = "stream";
		Map<String,ProcessInterface> pr = new HashMap<String, ProcessInterface>();
		pr.put("string", new StringProcess());
		pr.put("exception", new ProcessException());
		pr.put("interface", new ProcessInt());
		pr.put("date", new ProcessDate());
		pr.put("enum", new ProcessEnum());
		pr.put("collection", new ProcessCollection());
		pr.put("singletone", new ProcessSingleTone());
		pr.put("sequential", new ProcessSequential());
		pr.put("anonima", new ProcessAnonima());
		pr.put("stream", new ProcessStream());
			
		if (pr.containsKey(inp)) {
			try {
				ProcessInterface ex = pr.get(inp);
				ex.execute();
			} catch (AcademyException e) {
				System.out.println("Errore applicativo:" + e.getMessage());
				
			} catch (Exception e) {
				System.out.println("Abnomal end:" + e.getMessage());
				e.printStackTrace();
		}
		} else {
			System.out.println("process non previsto");
		}
	}
}
