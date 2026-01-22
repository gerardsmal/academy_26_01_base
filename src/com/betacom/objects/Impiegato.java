package com.betacom.objects;

import java.time.LocalDate;

import com.betacom.enums.Reparto;

public class Impiegato extends User{
	
	private Double salary;
	private Reparto reparto;

	public Impiegato() {
		super();
	}

	public Impiegato(String nome, String cognome, Boolean sesso, Double salary) {
		super(nome, cognome, sesso);
		
		this.salary = salary;
	}

	public Impiegato(String nome, String cognome, Boolean sesso, Double salary, String reparto) {
		super(nome, cognome, sesso);
		
		this.salary = salary;
		try {
			this.reparto = Reparto.valueOf(reparto);
		} catch (IllegalArgumentException e) {
			System.out.println("valore di riposto invalids");
		}
		
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
//
//	@Override
//	public Boolean getSesso() {
//		System.out.println("Il sesso dell'impiegato é " + (super.getSesso() ? "Maschio" : "Femina"));
//		return super.getSesso();
//	}
//	

	public Reparto getReparto() {
		return reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		String resp = "Impiegato [salary=" + salary;
		if (reparto != null) {
			resp = resp + ", reparto=" + reparto.toString();
		}
		resp = resp + ", getNome()=" + getNome() + ", getCognome()=" + getCognome()
		+ ", getSesso()=" + getSesso() + "]";
		
		return resp;
	}


}
