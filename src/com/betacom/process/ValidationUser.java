package com.betacom.process;

import com.betacom.exceptions.AcademyException;
import com.betacom.objects.User;

public class ValidationUser {
	
	public void checkUser(User usr) throws AcademyException{
		if (usr.getNome() == null)
			usr.setNome("No Name");

		if (usr.getCognome() == null)
			throw new AcademyException("Cognome non caricato");

		if (usr.getSesso() == null)
			throw new AcademyException("Sesso non caricato");

	}

}
