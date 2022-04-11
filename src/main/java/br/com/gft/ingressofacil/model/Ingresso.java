package br.com.gft.ingressofacil.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class Ingresso {
	private String nomeEvento;
	private String localEvento;
	private String dataEHorario;	
	private BigDecimal valorIngresso;
	@NotNull(message="Você deve adicionar pelo menos 1 ingresso na compra")
	@Min(value=1, message="Você deve comprar pelo menos 1 ingresso")
	private Integer quantidadeIngressosComprados;
	private BigDecimal totalDaCompra;
	private String ImagemDoEvento;
	private Long eventoId;
	
	
	
	public Long getEventoId() {
		return eventoId;
	}
	public void setEventoId(Long eventoId) {
		this.eventoId = eventoId;
	}
	public String getImagemDoEvento() {
		return ImagemDoEvento;
	}
	public void setImagemDoEvento(String imagemDoEvento) {
		ImagemDoEvento = imagemDoEvento;
	}
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
