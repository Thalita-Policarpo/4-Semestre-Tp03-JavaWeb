package br.edu.infnet.thalitapolicarpo.model.domain;

import java.util.List;

public class InspecoesHidrante {
	
	private Hidrante hidrante;
	private String dataInspecao;
    private boolean sinalizado;
    private boolean desobstruido;
    private boolean possuiChaveStorz;
    private int quantidadeMangueiras;
    private List<Integer> metragens;
    private List<String> validadesMangueiras;
    private String status;
    
        
	public InspecoesHidrante() {
		super();
	}

	public InspecoesHidrante(Hidrante hidrante, String dataInspecao, boolean sinalizado, boolean desobstruido, boolean possuiChaveStorz,
			int quantidadeMangueiras, List<Integer> metragens, List<String> validadesMangueiras) {
		super();
		this.hidrante = hidrante;
		this.dataInspecao = dataInspecao;
		this.sinalizado = sinalizado;
		this.desobstruido = desobstruido;
		this.possuiChaveStorz = possuiChaveStorz;
		this.quantidadeMangueiras = quantidadeMangueiras;
		this.metragens = metragens;
		this.validadesMangueiras= validadesMangueiras;
	}

	public Hidrante getHidrante() {
		return hidrante;
	}

	public void setHidrante(Hidrante hidrante) {
		this.hidrante = hidrante;
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

	public boolean isPossuiChaveStorz() {
		return possuiChaveStorz;
	}

	public void setPossuiChaveStorz(boolean possuiChaveStorz) {
		this.possuiChaveStorz = possuiChaveStorz;
	}

	public int getQuantidadeMangueiras() {
		return quantidadeMangueiras;
	}

	public void setQuantidadeMangueiras(int quantidadeMangueiras) {
		this.quantidadeMangueiras = quantidadeMangueiras;
	}

	public List<Integer> getMetragem() {
		return metragens;
	}

	public void setMetragem(List<Integer> metragem) {
		this.metragens = metragem;
	}

	public List<String> getValidadeMangueiras() {
		return validadesMangueiras;
	}

	public void setValidadeMangueiras(List<String> validadeMangueiras) {
		this.validadesMangueiras = validadeMangueiras;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append(getHidrante())
	            .append("\ndataInspecao=").append(dataInspecao)
	            .append("\nsinalizado=").append(sinalizado)
	            .append("\ndesobstruido=").append(desobstruido)
	            .append("\npossuiChaveStorz=").append(possuiChaveStorz)
	            .append("\nquantidadeMangueiras=").append(quantidadeMangueiras)
	            .append("\n");
	    
	    // Exibição das metragens
	    if (!metragens.isEmpty()) {
	        if (metragens.size() == 1) {
	            stringBuilder.append("metragem=").append(metragens.get(0));
	        } else {
	            for (int i = 0; i < metragens.size(); i++) {
	                stringBuilder.append("metragem mangueira ").append(i + 1).append(": ").append(metragens.get(i)).append("\n");
	            }
	        }
	    }

	    // Exibição das validades das mangueiras
	    if (!validadesMangueiras.isEmpty()) {
	        if (validadesMangueiras.size() == 1) {
	            stringBuilder.append("\nvalidadeMangueiras: ").append(validadesMangueiras.get(0));
	        } else {
	            stringBuilder.append("\n");
	            for (int i = 0; i < validadesMangueiras.size(); i++) {
	                stringBuilder.append("validade mangueira ").append(i + 1).append(": ").append(validadesMangueiras.get(i)).append("\n");
	            }
	        }
	    }

	    stringBuilder.append("\nStatus: ").append(status);
	    return stringBuilder.toString();
	}
}
