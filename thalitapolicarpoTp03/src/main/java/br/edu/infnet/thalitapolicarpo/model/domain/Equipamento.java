package br.edu.infnet.thalitapolicarpo.model.domain;

public abstract class Equipamento {
	protected int numeroControleInterno;
    protected String localizacao;
    
      
    
	public Equipamento() {
		super();
	}


	public Equipamento(int numeroControleInterno, String localizacao) {
		super();
		this.numeroControleInterno = numeroControleInterno;
		this.localizacao = localizacao;
	}


	public int getNumeroControleInterno() {
		return numeroControleInterno;
	}


	public void setNumeroControleInterno(int numeroControleInterno) {
		this.numeroControleInterno = numeroControleInterno;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	@Override
	public String toString() {
		return "NºControle Interno: " + numeroControleInterno 
				+ "\nLocalização: " + localizacao;
	}
    
	
	
    
}
