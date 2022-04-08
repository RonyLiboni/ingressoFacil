package br.com.gft.ingressofacil.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.gft.ingressofacil.model.CasaDeShow;
import br.com.gft.ingressofacil.model.Evento;
import br.com.gft.ingressofacil.model.GeneroMusical;
import br.com.gft.ingressofacil.model.Ingresso;
import br.com.gft.ingressofacil.repository.EventoRepository;

@Service
public class EventoService {

	private final EventoRepository eventoRepository;

	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public void salvar(Evento evento) {
		eventoRepository.save(evento);
	}

	public List<Evento> listarEventos() {
		return eventoRepository.findAll();
	}

	public void deletarPeloId(Long id) {
		eventoRepository.deleteById(id);
	}

	public Evento acharPeloId(Long id) {
		return eventoRepository.findById(id).get();
	}

	public void atualizaDadosDoEvento(Long id, Integer quantidadeIngressosComprados) {
		Evento evento = acharPeloId(id);
		
		evento.setQuantidadeIngressosVendidos(quantidadeIngressosComprados + 
				evento.getQuantidadeIngressosVendidos());
		
		evento.setQuantidadeIngressosDisponiveis(
				evento.getQuantidadeIngressos() - evento.getQuantidadeIngressosVendidos());
		
		eventoRepository.save(evento);
		
	}

	public Ingresso toIngresso(Long id, Ingresso ingresso) {
		Evento evento = acharPeloId(id);
		ingresso.setNomeEvento(evento.getNomeEvento());
		ingresso.setLocalEvento(evento.getCasaDeShow().getNomeCasa());
		ingresso.setDataEHorario(evento.getDataEvento().toString() + " as " + evento.getHoraEvento().toString());
		ingresso.setValorIngresso(evento.getValorIngresso());

		BigDecimal valorTotalDaCompra = ingresso.getValorIngresso()
				.multiply(new BigDecimal(ingresso.getQuantidadeIngressosComprados().toString()));

		ingresso.setTotalDaCompra(valorTotalDaCompra);
		ingresso.setImagemDoEvento(evento.getImagemDoEvento());
		return ingresso;
	}

	public void popularBancoComEventos(CasaDeShow casaDeShow) {
		Evento evento = new Evento();
		evento.setNomeEvento("Rock in Rio");
		evento.setQuantidadeIngressos(100000);
		evento.setDataEvento(LocalDate.of(2022, Month.DECEMBER, 6));
		evento.setGeneroMusical(GeneroMusical.ROCK);
		evento.setCasaDeShow(casaDeShow);
		evento.setValorIngresso(new BigDecimal("550"));
		evento.setImagemDoEvento("https://capricho.abril.com.br/wp-content/uploads/2021/09/rock-in-rio-1.jpg");
		LocalTime horarioEvento = LocalTime.of(8, 00);
		evento.setHoraEvento(horarioEvento);
		evento.setQuantidadeIngressosDisponiveis(evento.getQuantidadeIngressos());
		salvar(evento);

		Evento evento2 = new Evento();
		evento2.setNomeEvento("Kiss - End of the Road");
		evento2.setQuantidadeIngressos(30000);
		evento2.setDataEvento(LocalDate.of(2022, Month.MAY, 17));
		evento2.setGeneroMusical(GeneroMusical.ROCK);
		evento2.setCasaDeShow(casaDeShow);
		evento2.setValorIngresso(new BigDecimal("430"));
		evento2.setImagemDoEvento(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIteUsB-YQMuF9KOL5afdKTLFbevSK3q0_nQ&usqp=CAU");
		horarioEvento = LocalTime.of(20, 00);
		evento2.setHoraEvento(horarioEvento);
		evento2.setQuantidadeIngressosDisponiveis(evento2.getQuantidadeIngressos());
		salvar(evento2);

		Evento evento3 = new Evento();
		evento3.setNomeEvento("Zé Neto & Cristiano");
		evento3.setQuantidadeIngressos(18000);
		evento3.setDataEvento(LocalDate.of(2022, Month.AUGUST, 6));
		evento3.setGeneroMusical(GeneroMusical.SERTANEJO);
		evento3.setCasaDeShow(casaDeShow);
		evento3.setValorIngresso(new BigDecimal("120"));
		evento3.setImagemDoEvento(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7TVxa2MBNOTlINqrUgIZpGthT7NUqgGk4Rg&usqp=CAU");
		horarioEvento = LocalTime.of(21, 00);
		evento3.setHoraEvento(horarioEvento);
		evento3.setQuantidadeIngressosDisponiveis(evento3.getQuantidadeIngressos());
		salvar(evento3);

		Evento evento5 = new Evento();
		evento5.setNomeEvento("Anitta");
		evento5.setQuantidadeIngressos(30000);
		evento5.setDataEvento(LocalDate.of(2022, Month.MAY, 6));
		evento5.setGeneroMusical(GeneroMusical.FUNK);
		evento5.setCasaDeShow(casaDeShow);
		evento5.setValorIngresso(new BigDecimal("200"));
		evento5.setImagemDoEvento(
				"https://upload.wikimedia.org/wikipedia/pt/thumb/8/8f/Kisses_-_Anitta.png/220px-Kisses_-_Anitta.png");
		horarioEvento = LocalTime.of(22, 00);
		evento5.setHoraEvento(horarioEvento);
		evento5.setQuantidadeIngressosDisponiveis(evento5.getQuantidadeIngressos());
		salvar(evento5);

		Evento evento6 = new Evento();
		evento6.setNomeEvento("Luisa Sonza");
		evento6.setQuantidadeIngressos(18000);
		evento6.setDataEvento(LocalDate.of(2022, Month.MAY, 17));
		evento6.setGeneroMusical(GeneroMusical.FUNK);
		evento6.setCasaDeShow(casaDeShow);
		evento6.setValorIngresso(new BigDecimal("140"));
		evento6.setImagemDoEvento("https://www.universalmusic.com.br/files/2020/03/Lu%C3%ADsa-Sonza.jpg");
		horarioEvento = LocalTime.of(22, 00);
		evento6.setHoraEvento(horarioEvento);
		evento6.setQuantidadeIngressosDisponiveis(evento6.getQuantidadeIngressos());
		salvar(evento6);
	}


}
