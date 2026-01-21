package com.betacom.objects;

import java.time.LocalDate;

public class User {
	/*
	 * public: visible ovunque
	 * protected : visibile dalle class figlie e dallo stesso package
	 * private ; visibile della stess class
	 * default (nessun modificatore) : visibile dalle classi dello stesso package
	 */
	
	private String nome;
	private String cognome;
	private Boolean sesso;
	private LocalDate dataNascita;
	private LocalDate dataCerticatiMedico;
	private Integer meseDiValidita;

	public User() {
		super();
	}


	public User(String nome, String cognome, Boolean sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}

	public User(String nome, String cognome, String sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = ("M".equals(sesso)) ? true : false;
	}


	public User(String nome, String cognome, String sesso, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = ("M".equals(sesso)) ? true : false;
		this.dataNascita = dataNascita;
	}

	public User(String nome, String cognome, String sesso, int anno, int mese, int giorno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = ("M".equals(sesso)) ? true : false;
		this.dataNascita = LocalDate.of(anno, mese, giorno);
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Boolean getSesso() {
		return sesso;
	}

	public void setSesso(Boolean sesso) {
		this.sesso = sesso;
	}


	public LocalDate getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataCerticatiMedico() {
		return dataCerticatiMedico;
	}


	public void setDataCerticatiMedico(LocalDate dataCerticatiMedico) {
		this.dataCerticatiMedico = dataCerticatiMedico;
	}


	public Integer getMeseDiValidita() {
		return meseDiValidita;
	}


	public void setMeseDiValidita(Integer meseDiValidita) {
		this.meseDiValidita = meseDiValidita;
	}


	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", dataCerticatiMedico=" + dataCerticatiMedico + ", meseDiValidita=" + meseDiValidita + "]";
	}



	
}
