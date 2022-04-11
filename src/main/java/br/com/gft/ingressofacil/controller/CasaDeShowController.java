package br.com.gft.ingressofacil.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gft.ingressofacil.model.CasaDeShow;
import br.com.gft.ingressofacil.service.CasaDeShowService;

@Controller
@RequestMapping("/casaDeShow")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowService casaDeShowService;

	@GetMapping
	public String listarCasasDeShow(Model model, CasaDeShow casaDeShow) {
		List<CasaDeShow> listaCasaDeShow = casaDeShowService.listarCasasDeShow();
		model.addAttribute("listaCasaDeShow", listaCasaDeShow);
		return "/admin/casaDeShows";
	}

	@PostMapping("cadastrar")
	public String cadastrarCasaDeShow(@Valid CasaDeShow casaDeShow, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return listarCasasDeShow(model, casaDeShow);

		casaDeShowService.salvar(casaDeShow);

		redirectAttributes.addFlashAttribute("mensagem", "Ação feita com sucesso!");

		return "redirect:/casaDeShow";
	}

	@GetMapping("editar")
	public String editarCasaDeShow(Long id, Model model) {
		CasaDeShow casaDeShow = casaDeShowService.acharPeloId(id);
		model.addAttribute("casaDeShow", casaDeShow);
		model.addAttribute("mensagem", "Agora você pode alterar os dados que precisa!");
		return listarCasasDeShow(model, casaDeShow);
	}

	@GetMapping("deletar")
	public String deletarCasaDeShow(Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			casaDeShowService.deletarPeloId(id);
		} catch (DataIntegrityViolationException e) {
			CasaDeShow casaDeShow = new CasaDeShow();
			model.addAttribute("casaDeShow", casaDeShow);
			model.addAttribute("mensagem", "Esta casa não pode ser excluida, pois tem eventos marcados nela!");
			return listarCasasDeShow(model, casaDeShow);
		} catch (EmptyResultDataAccessException e) {
			CasaDeShow casaDeShow = new CasaDeShow();
			model.addAttribute("casaDeShow", casaDeShow);
			model.addAttribute("mensagem", "A casa com id " + id + " não pode ser excluida, pois não existe!");
			return listarCasasDeShow(model, casaDeShow);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Casa excluida com sucesso!");

		return "redirect:/casaDeShow";
	}

	@GetMapping("inserirCasasDeShow")
	public String popularCasasDeShow(RedirectAttributes redirectAttributes) {
		casaDeShowService.popularBancoComCasas();
		redirectAttributes.addFlashAttribute("mensagem", "Casa de show populada com sucesso!");
		return "redirect:/casaDeShow";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String onError() {
		return "redirect:/casaDeShow";
	}

}
