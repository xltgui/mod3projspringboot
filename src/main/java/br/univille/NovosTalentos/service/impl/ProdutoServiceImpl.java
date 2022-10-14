package br.univille.NovosTalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.NovosTalentos.entity.Produto;
import br.univille.NovosTalentos.repository.ProdutoRepository;
import br.univille.NovosTalentos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public List<Produto> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public Produto findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Produto();
    }

    @Override
    public void delete(long id){
        repositorio.deleteById(id);
    }

}
