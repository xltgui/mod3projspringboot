package br.univille.NovosTalentos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.NovosTalentos.entity.Produto;
import br.univille.NovosTalentos.service.CidadeService;
import br.univille.NovosTalentos.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index() {

        var listaDeProdutos = service.getAll();

        return new ModelAndView("produto/index", "listaDeProdutos", listaDeProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoProduto = new Produto();
        var listaCidades = cidadeService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaCidades", listaCidades);
        dados.put("produto", novoProduto);
        return new ModelAndView("produto/form", dados);
    }

    @PostMapping(params = "form") // código para o botao Enviar dps de cadastrar um novo produto funcionar;
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umProduto = service.findById(id);
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaCidades", listaCidades);
        dados.put("produto", umProduto);
        return new ModelAndView("/produto/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/produtos");
    }
}
