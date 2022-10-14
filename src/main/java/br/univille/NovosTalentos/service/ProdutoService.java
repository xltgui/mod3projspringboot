package br.univille.NovosTalentos.service;

import java.util.List;

import br.univille.NovosTalentos.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();
    Produto save(Produto produto);

    Produto findById(long id);
    void delete(long id);
}
