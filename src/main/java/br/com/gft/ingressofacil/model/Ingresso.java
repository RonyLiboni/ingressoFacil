package br.com.gft.ingressofacil.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Ingresso {
	private String nomeEvento;
	private String localEvento;
	private String dataEHorario;	
	private BigDecimal valorIngresso;
	@NotNull
	private Integer quantidadeIngressosComprados;
	private BigDecimal totalDaCompra;
	
	
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}
	public String getDataEHorario() {
		return dataEHorario;
	}
	public void setDataEHorario(String dataEHorario) {
		this.dataEHorario = dataEHorario;
	}
	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(BigDecimal valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	public Integer getQuantidadeIngressosComprados() {
		return quantidadeIngressosComprados;
	}
	public void setQuantidadeIngressosComprados(Integer quantidadeIngressosComprados) {
		this.quantidadeIngressosComprados = quantidadeIngressosComprados;
	}
	public BigDecimal getTotalDaCompra() {
		return totalDaCompra;
	}
	public void setTotalDaCompra(BigDecimal totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}
	
	
	
	
}
