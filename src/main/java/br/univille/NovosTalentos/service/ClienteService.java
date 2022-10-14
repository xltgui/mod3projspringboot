package br.univille.NovosTalentos.service;

import java.util.List;
import br.univille.NovosTalentos.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    Cliente save(Cliente cliente);
    Cliente findById(long id);
    //Cliente delete(Cliente cliente);

    void delete(long id);
}