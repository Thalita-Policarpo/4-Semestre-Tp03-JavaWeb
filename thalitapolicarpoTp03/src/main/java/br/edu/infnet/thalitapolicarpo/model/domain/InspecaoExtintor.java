package br.edu.infnet.thalitapolicarpo.model.domain;

public class InspecaoExtintor {
    private Extintor extintor;
    private String dataInspecao;
    private boolean sinalizado;
    private boolean desobstruido;
    private boolean manometroPressaoAdequada;
    private boolean gatilhoBoasCondicoes;
    private boolean mangoteBoasCondicoes;
    private boolean rotuloPinturaBoasCondicoes;
    private boolean suporteBoasCondicoes;
    private boolean lacreIntacto;
    private String status;

    public InspecaoExtintor() { }

    public InspecaoExtintor(Extintor extintor, String dataInspecao, boolean sinalizado, boolean desobstruido,
                            boolean manometroPressaoAdequada, boolean gatilhoBoasCondicoes, boolean mangoteBoasCondicoes,
                            boolean rotuloPinturaBoasCondicoes, boolean suporteBoasCondicoes, boolean lacreIntacto) {
        this.extintor = extintor;
        this.dataInspecao = dataInspecao;
        this.sinalizado = sinalizado;
        this.desobstruido = desobstruido;
        this.manometroPressaoAdequada = manometroPressaoAdequada;
        this.gatilhoBoasCondicoes = gatilhoBoasCondicoes;
        this.mangoteBoasCondicoes = mangoteBoasCondicoes;
        this.rotuloPinturaBoasCondicoes = rotuloPinturaBoasCondicoes;
        this.suporteBoasCondicoes = suporteBoasCondicoes;
        this.lacreIntacto = lacreIntacto;
    }

    // Getters and Setters

	public Extintor getExtintor() {
		return extintor;
	}

	public void setExtintor(Extintor extintor) {
		this.extintor = extintor;
	}

	public String getDataInspecao() {
		return dataInspecao;
	}

	public void setDataInspecao(String dataInspecao) {
		this.dataInspecao = dataInspecao;
	}

	public boolean isSinalizado() {
		return sinalizado;
	}

	public void setSinalizado(boolean sinalizado) {
		this.sinalizado = sinalizado;
	}

	public boolean isDesobstruido() {
		return desobstruido;
	}

	public void setDesobstruido(boolean desobstruido) {
		this.desobstruido = desobstruido;
	}

	public boolean isManometroPressaoAdequada() {
		return manometroPressaoAdequada;
	}

	public void setManometroPressaoAdequada(boolean manometroPressaoAdequada) {
		this.manometroPressaoAdequada = manometroPressaoAdequada;
	}

	public boolean isGatilhoBoasCondicoes() {
		return gatilhoBoasCondicoes;
	}

	public void setGatilhoBoasCondicoes(boolean gatilhoBoasCondicoes) {
		this.gatilhoBoasCondicoes = gatilhoBoasCondicoes;
	}

	public boolean isMangoteBoasCondicoes() {
		return mangoteBoasCondicoes;
	}

	public void setMangoteBoasCondicoes(boolean mangoteBoasCondicoes) {
		this.mangoteBoasCondicoes = mangoteBoasCondicoes;
	}

	public boolean isRotuloPinturaBoasCondicoes() {
		return rotuloPinturaBoasCondicoes;
	}

	public void setRotuloPinturaBoasCondicoes(boolean rotuloPinturaBoasCondicoes) {
		this.rotuloPinturaBoasCondicoes = rotuloPinturaBoasCondicoes;
	}

	public boolean isSuporteBoasCondicoes() {
		return suporteBoasCondicoes;
	}

	public void setSuporteBoasCondicoes(boolean suporteBoasCondicoes) {
		this.suporteBoasCondicoes = suporteBoasCondicoes;
	}

	public boolean isLacreIntacto() {
		return lacreIntacto;
	}

	public void setLacreIntacto(boolean lacreIntacto) {
		this.lacreIntacto = lacreIntacto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return  getExtintor()
				+ "\nData da Inspeção: " + dataInspecao
				+ "\nSinalizado: " + sinalizado
				+ "\nDesobstruido: " + desobstruido
				+ "\nManometro com pressão adequada: " + manometroPressaoAdequada
				+ "\nGatilho em boas condições: " + gatilhoBoasCondicoes
				+ "\nMangote em boas condições: " + mangoteBoasCondicoes
				+ "\nRotulo e pintura em boas condições: " + rotuloPinturaBoasCondicoes
				+ "\nSuporte em boas condições: " + suporteBoasCondicoes
				+ "\nLacre intacto: " + lacreIntacto
				+ "\nSituação do equipamento: " + status;
	}
}
