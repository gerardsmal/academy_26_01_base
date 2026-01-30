package com.betacom.objects;

public class Inner {
	private String fatherClass;
	private int numero;
	private Figlio f;

	public class Figlio{
		private int numero2;
		private String figlioClass;
		private Nipote n;
		
		public class Nipote extends Impiegato{
			private int numero3;
			private String nipoteClass;
			
			public int getNumero3() {
				return numero3;
			}
			public void setNumero3(int numero3) {
				this.numero3 = numero3;
			}
			public String getNipoteClass() {
				return nipoteClass;
			}
			public void setNipoteClass(String nipoteClass) {
				this.nipoteClass = nipoteClass;
			}
			public String displayNumberNipote() {
				return ">> padre:" + numero + " figlio:" + numero2 + " nipote:" + numero3;
			}

		}
		
		public int getNumero2() {
			return numero2;
		}
		public void setNumero2(int numero2) {
			this.numero2 = numero2;
		}
		public String getFiglioClass() {
			return figlioClass;
		}
		public void setFiglioClass(String figlioClass) {
			this.figlioClass = figlioClass;
		}
		
		public String displayNumber() {
			return ">> padre:" + numero + " figlio:" + numero2;
		}
		public Nipote setInstanceNipote() {
			n = new Nipote();
			return n;
		}

		
	}
	
	
	
	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFatherClass() {
		return fatherClass;
	}

	public void setFatherClass(String fatherClass) {
		this.fatherClass = fatherClass;
	}
	
	public Figlio setInstanceFiglio() {
		f = new Figlio();
		return f;
	}
	

}
