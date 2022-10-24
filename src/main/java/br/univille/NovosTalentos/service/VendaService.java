package br.univille.NovosTalentos.service;

import java.util.List;

import br.univille.NovosTalentos.entity.Venda;

public interface VendaService {
    List<Venda> getAll();
    Venda save(Venda venda);

    Venda findById(long id);
    void delete(long id);
}
