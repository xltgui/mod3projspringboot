package br.univille.NovosTalentos.controller;

import java.security.Provider.Service;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.NovosTalentos.entity.ItemVenda;
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

    @Autowired 
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(){
        var listaVendas = vendaService.getAll();
        return new ModelAndView("venda/index", "listaVendas", listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaVenda = new Venda();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("venda", novaVenda);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Venda venda){
        vendaService.save(venda);
        return new ModelAndView("redirect:/vendas");
    }
    
    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda, ItemVenda novoItem){
        venda.getColItens().add(novoItem);

        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("venda", venda);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);

    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, 
                                    Venda venda){
        venda.getColItens().remove(index);
        
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("venda", venda);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);
    }



}
