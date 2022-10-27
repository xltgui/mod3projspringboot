package br.univille.NovosTalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.NovosTalentos.entity.Cliente;
import br.univille.NovosTalentos.repository.ClienteRepository;
import br.univille.NovosTalentos.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> getAll() {
        return repositorio.findAll();
    }
    
    @Override
    public Cliente save(Cliente cliente){
        return repositorio.save(cliente);
    }

    @Override
    public Cliente findById(long id){
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Cliente();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
}
