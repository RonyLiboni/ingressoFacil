package br.com.gft.ingressofacil.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gft.ingressofacil.model.CasaDeShow;
import br.com.gft.ingressofacil.repository.CasaDeShowRepository;

@Service
public class CasaDeShowService {
	
	private final CasaDeShowRepository casaDeShowRepository;

	public CasaDeShowService(CasaDeShowRepository casaDeShowRepository) {
		this.casaDeShowRepository = casaDeShowRepository;
	}
	
	public void salvar(CasaDeShow casaDeShow) {
		casaDeShowRepository.save(casaDeShow);
	}
	
	public List<CasaDeShow> listarCasasDeShow() {
		return casaDeShowRepository.findAll();
	}
	
	public void deletarPeloId(Long id) {
		casaDeShowRepository.deleteById(id);
	}
	
	public CasaDeShow acharPeloId(Long id) {
		return casaDeShowRepository.findById(id).get();
	}
	
	public void popularBancoComCasas() {
		CasaDeShow casa = new CasaDeShow();
		casa.setNomeCasa("Arena do Grêmio");
		casa.setEndereco("Av. Padre Leopoldo Brentano, 110 - Farrapos, Porto Alegre - RS, 90250-590");
		salvar(casa);
		
		CasaDeShow casa2 = new CasaDeShow();
		casa2.setNomeCasa("Gigantinho");
		casa2.setEndereco("Avenida Padre Cacique, 891 Ao lado do estádio Beira-Rio - Praia de Belas, Porto Alegre - RS, 90810-240");
		salvar(casa2);
		
		CasaDeShow casa3 = new CasaDeShow();
		casa3.setNomeCasa("FIERGS");
		casa3.setEndereco("Av. Assis Brasil, 8787 - Sarandi, Porto Alegre - RS, 91140-001");
		salvar(casa3);
	}
	
	
	
}
