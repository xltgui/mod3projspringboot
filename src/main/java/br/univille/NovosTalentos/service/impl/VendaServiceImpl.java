package br.univille.NovosTalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.NovosTalentos.entity.Venda;
import br.univille.NovosTalentos.repository.VendaRepository;
import br.univille.NovosTalentos.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService{
    @Autowired
    private VendaRepository repositorio;

    @Override
    public List<Venda> getAll() {

        return repositorio.findAll();
    }

    @Override
    public Venda save(Venda venda) {
        return repositorio.save(venda);
    }

    @Override
    public Venda findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Venda();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
