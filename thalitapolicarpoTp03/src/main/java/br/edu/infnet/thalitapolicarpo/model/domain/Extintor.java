package br.edu.infnet.thalitapolicarpo.model.domain;

public class Extintor extends Equipamento {
    private String numeroCilindro;
    private String numeroSeloInmetro;
    private String cargaExtintora;
    private String capacidade;
    private String dataVencimento;
    private int proximoTesteHidrostatico;

    public Extintor() {
    	super();
    }

    public Extintor(int numeroControleInterno, String localizacao,String numeroCilindro, String numeroSeloInmetro,
                    String cargaExtintora, String capacidade, String dataVencimento, int proximoTesteHidrostatico) {
        super (numeroControleInterno, localizacao);
        this.numeroCilindro = numeroCilindro;
        this.numeroSeloInmetro = numeroSeloInmetro;
        this.cargaExtintora = cargaExtintora;
        this.capacidade = capacidade;
        this.dataVencimento = dataVencimento;
        this.proximoTesteHidrostatico = proximoTesteHidrostatico;
    }

    // Getters and Setters
    
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

	public String getNumeroCilindro() {
		return numeroCilindro;
	}

	public void setNumeroCilindro(String numeroCilindro) {
		this.numeroCilindro = numeroCilindro;
	}

	public String getNumeroSeloInmetro() {
		return numeroSeloInmetro;
	}

	public void setNumeroSeloInmetro(String numeroSeloInmetro) {
		this.numeroSeloInmetro = numeroSeloInmetro;
	}

	public String getCargaExtintora() {
		return cargaExtintora;
	}

	public void setCargaExtintora(String cargaExtintora) {
		this.cargaExtintora = cargaExtintora;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getProximoTesteHidrostatico() {
		return proximoTesteHidrostatico;
	}

	public void setProximoTesteHidrostatico(int proximoTesteHidrostatico) {
		this.proximoTesteHidrostatico = proximoTesteHidrostatico;
	}
	
	
	@Override
	public String toString() {
		return "\nNº Controle Interno:" + getNumeroControleInterno()
		+ "\nLocalização:" + getLocalizacao()
		+ "\nExtintor:" + getNumeroCilindro()
		+ "\nSelo do Inmetro:" + getNumeroSeloInmetro()
		+ "\nCarga Extintora:" + getCargaExtintora()
		+ "\nCapacidade:" + getCapacidade()
		+ "\nData de vencimento:" + getDataVencimento()
		+ "\nProximo Teste Hidrostatico:" + getProximoTesteHidrostatico();
	}
}
