package com.betacom.objects;

public class Impiegato extends User{
	
	private Double salary;

	public Impiegato() {
		super();
	}

	public Impiegato(String nome, String cognome, Boolean sesso, Double salary) {
		super(nome, cognome, sesso);
		
		this.salary = salary;
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public Boolean getSesso() {
		System.out.println("Il sesso dell'impiegato é " + (super.getSesso() ? "Maschio" : "Femina"));
		return super.getSesso();
	}
	
	@Override
	public String toString() {
		return "Impiegato [salary=" + salary + ", getNome()=" + getNome() + ", getCognome()=" + getCognome()
				+ ", getSesso()=" + getSesso() + "]";
	}

}
