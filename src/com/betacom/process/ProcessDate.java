package com.betacom.process;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.User;
import com.betacom.utils.Utilities;

public class ProcessDate  implements ProcessInterface{
	
	private final static String PATTERN_DATE = "d/M/yyyy";
	private final static String PATTERN_DATE_ESTESO = "EEEE dd MMMM yyyy HH:mm:ss";
	private final static String PATTERN_DATE_ESTESO_GIORNO = "EEEE dd MMMM yyyy";
	private final static String PATTERN_DATE_ESTESO_ORA = "HH:mm:ss";

	@Override
	public boolean execute() throws Exception {
		System.out.println("Being ProcessDate");
		
		LocalDateTime adesso = LocalDateTime.now();
		
		String r = String.format("Adesso siamo il  %s", Utilities.dateToString(PATTERN_DATE, adesso));		
		System.out.println(r);
		
		r = String.format("Adesso siamo il  %s ora: %s" , Utilities.dateToString(PATTERN_DATE_ESTESO_GIORNO, adesso),
									Utilities.dateToString(PATTERN_DATE_ESTESO_ORA, adesso	));
		System.out.println(r);
		
		/*
		 * date in User
		 */
		LocalDate u = LocalDate.parse("1970-10-05");
		
		User usr = new User("Marco", "Verde", "M", u);
		System.out.println(usr);
		
		usr = new User("Anna", "Bianco", "F", 2000, 12, 10);
		System.out.println("Data nascita:" + Utilities.dateToString(PATTERN_DATE, usr.getDataNascita()));
		
		int plusGiorni = 25;
		usr.setDataNascita(usr.getDataNascita().plusDays(plusGiorni));
		
		System.out.println("Data nascita modificata:" + Utilities.dateToString(PATTERN_DATE, usr.getDataNascita()));
		
		String dateParam = "10/6/2025";
		
		usr.setDataCerticatiMedico(Utilities.stringToDate(PATTERN_DATE, dateParam));
		usr.setMeseDiValidita(12);
		System.out.println(usr);
		
		/*
		 * control validita certificato medico
		 */
		LocalDate endDate = usr.getDataCerticatiMedico().plusMonths(usr.getMeseDiValidita());
		System.out.println(Utilities.dateToString(PATTERN_DATE, endDate));
		
		if (LocalDate.now().isAfter(endDate))
			System.out.println("certificato medico scaduto " + Utilities.dateToString(PATTERN_DATE_ESTESO_GIORNO, usr.getDataCerticatiMedico()));
		else
			System.out.println("certificato medico valido " + Utilities.dateToString(PATTERN_DATE_ESTESO_GIORNO, usr.getDataCerticatiMedico()));
		return false;
	}

}
