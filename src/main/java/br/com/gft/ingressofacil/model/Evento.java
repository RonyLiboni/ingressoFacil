package br.com.gft.ingressofacil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message="Você deve informar o nome do evento")
	private String nomeEvento;
	@NotNull (message="Você deve informar o valor do ingresso") @Digits(fraction = 2, integer = 10)
	private BigDecimal valorIngresso;
	@Enumerated(EnumType.STRING)
	private GeneroMusical generoMusical;
	@ManyToOne (fetch = FetchType.LAZY)
	private CasaDeShow casaDeShow;
	
	@NotNull(message="Você deve informar a data do evento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="Você só pode cadastrar eventos que ocorrerão no futuro!")
	private LocalDate dataEvento;
	
	@NotNull(message="Você deve informar o horario do evento")
	private LocalTime horaEvento;
	@NotNull @Digits(fraction=0 ,integer =10)
	private Integer quantidadeIngressos;
	private Integer quantidadeIngressosVendidos=0;
	private Integer quantidadeIngressosDisponiveis;
	private String imagemDoEvento;
		
	
	public LocalTime getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(LocalTime horaEvento) {
		this.horaEvento = horaEvento;
	}
	public Integer getQuantidadeIngressosVendidos() {
		return quantidadeIngressosVendidos;
	}
	public void setQuantidadeIngressosVendidos(Integer quantidadeIngressosVendidos) {
		this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
	}
	public Integer getQuantidadeIngressosDisponiveis() {
		return quantidadeIngressosDisponiveis;
	}
	public void setQuantidadeIngressosDisponiveis(Integer quantidadeIngressosDisponiveis) {
		this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
	}
	public Integer getQuantidadeIngressos() {
		return quantidadeIngressos;
	}
	public String getImagemDoEvento() {
		return imagemDoEvento;
	}
	public void setImagemDoEvento(String imagemDoEvento) {
		this.imagemDoEvento = imagemDoEvento;
	}
	public void setQuantidadeIngressos(Integer quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(BigDecimal valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	
	public GeneroMusical getGeneroMusical() {
		return generoMusical;
	}
	public void setGeneroMusical(GeneroMusical generoMusical) {
		this.generoMusical = generoMusical;
	}
	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}
	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
		
	
}
