package br.univille.NovosTalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.NovosTalentos.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    private VendaService service;

    @GetMapping
    public ModelAndView index(){
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index", "listaVendas", listaVendas);
    }

}
