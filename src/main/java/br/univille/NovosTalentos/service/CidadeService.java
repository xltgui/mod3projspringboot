package br.univille.NovosTalentos.service;

import java.util.List;
import br.univille.NovosTalentos.entity.Cidade;

public interface CidadeService {
    List<Cidade> getAll();
    Cidade save(Cidade cidade);
    Cidade findById(long id);
    //Cidade delete(Cidade cidade);
    void delete(long id);
}
