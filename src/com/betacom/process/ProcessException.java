package com.betacom.process;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.User;

public class ProcessException implements ProcessInterface{

	@Override
	public boolean execute() throws Exception, AcademyException{
		System.out.println("Begin ProcessException");
		
		int p1 = 10;
		int p2 = 2;
		
		int res = p1/p2;
			

		User usr = new User();
		usr.setNome("Bruno");
		usr.setCognome("Caligero");
//		usr.setSesso(true);
		ValidationUser v = new ValidationUser();
		
		try {
			v.checkUser(usr);
		} catch (AcademyException e) {
			throw new AcademyException(e.getMessage());
		}
		System.out.println("User validato normalmente");
		 
		
		
		return true;
	}

}
