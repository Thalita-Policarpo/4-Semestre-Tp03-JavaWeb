package br.edu.infnet.thalitapolicarpo.model.domain;

public class Hidrante extends Equipamento {
	
    private String dataDeInstalacao;
    private String alturaDeFixacao;
    private String tipoDeHidrante;
    private String diametroRegistroGlobo;
    private String corDaTubulacao;
    
        
    
	public Hidrante() {
		super();
	}


	public Hidrante(int numeroControleInterno, String localizacao, String dataDeInstalacao, String alturaDeFixacao, String tipoDeHidrante,
			String diametroRegistroGlobo, String corDaTubulacao) {
		super(numeroControleInterno, localizacao);
		this.dataDeInstalacao = dataDeInstalacao;
		this.alturaDeFixacao = alturaDeFixacao;
		this.tipoDeHidrante = tipoDeHidrante;
		this.diametroRegistroGlobo = diametroRegistroGlobo;
		this.corDaTubulacao = corDaTubulacao;
	}


	public String getDataDeInstalacao() {
		return dataDeInstalacao;
	}


	public void setDataDeInstalacao(String dataDeInstalacao) {
		this.dataDeInstalacao = dataDeInstalacao;
	}


	public String getAlturaDeFixacao() {
		return alturaDeFixacao;
	}


	public void setAlturaDeFixacao(String alturaDeFixacao) {
		this.alturaDeFixacao = alturaDeFixacao;
	}


	public String getTipoDeHidrante() {
		return tipoDeHidrante;
	}


	public void setTipoDeHidrante(String tipoDeHidrante) {
		this.tipoDeHidrante = tipoDeHidrante;
	}


	public String getDiametroRegistroGlobo() {
		return diametroRegistroGlobo;
	}


	public void setDiametroRegistroGlobo(String diametroRegistroGlobo) {
		this.diametroRegistroGlobo = diametroRegistroGlobo;
	}


	public String getCorDaTubulacao() {
		return corDaTubulacao;
	}


	public void setCorDaTubulacao(String corDaTubulacao) {
		this.corDaTubulacao = corDaTubulacao;
	}


	@Override
	public String toString() {
		return "Data de instalação: " + dataDeInstalacao 
				+ "\nAltura de fixação: " + alturaDeFixacao
				+ "\nTipo de Hidrante: " + tipoDeHidrante 
				+ "\nDiametro do Registro Globo: " + diametroRegistroGlobo
				+ "\nCor da tubulação=" + corDaTubulacao;
	}

    
	
	
}
