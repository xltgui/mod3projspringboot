package br.univille.NovosTalentos.controller;

import java.util.HashMap;

import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.NovosTalentos.entity.Cliente;
import br.univille.NovosTalentos.entity.Venda;
import br.univille.NovosTalentos.service.ClienteService;
import br.univille.NovosTalentos.service.ProdutoService;
import br.univille.NovosTalentos.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(){
        var listaVendas = vendaService.getAll();
        return new ModelAndView("venda/index", "listaVendas", listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaVenda = new Venda();
        var listaClientes = clienteService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("venda", novaVenda);
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Venda venda){
        vendaService.save(venda);
        return new ModelAndView("redirect:/vendas");
    }

}
