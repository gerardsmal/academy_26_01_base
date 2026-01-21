package com.betacom;

import java.util.Scanner;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.process.ProcessDate;
import com.betacom.process.ProcessEnum;
import com.betacom.process.ProcessException;
import com.betacom.process.ProcessInt;
import com.betacom.process.StringProcess;

public class MainProcess {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Introdure un parametro [interface,string,exception, date, enum]:");
//		String inp = sc.nextLine();
		String inp = "enum";
		ProcessInterface pr = null;
		
		switch (inp) {
			case "string": {
				pr = new StringProcess();
				break;
			}
			case "exception": {
				pr = new ProcessException();
				break;
			}
			case "interface": {
				pr = new ProcessInt();
				break;
			}
			case "date": {
				pr = new ProcessDate();
				break;
			}
			case "enum": {
				pr = new ProcessEnum();
				break;
			}

			default:{
				System.out.println("process non previsto");
				System.exit(1);
			}
		}
		
		try {
			pr.execute();
			System.out.println("Normal end");
		} catch (AcademyException e) {
			System.out.println("Errore applicativo:" + e.getMessage());
			
		} catch (Exception e) {
			System.out.println("Abnomal end:" + e.getMessage());
			e.printStackTrace();
	}

	}
}
