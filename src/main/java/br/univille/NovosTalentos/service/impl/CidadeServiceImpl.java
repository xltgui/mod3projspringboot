package br.univille.NovosTalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.NovosTalentos.entity.Cidade;
import br.univille.NovosTalentos.repository.CidadeRepository;
import br.univille.NovosTalentos.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
    
    @Autowired
    private CidadeRepository repositorio;

    @Override
    public List<Cidade> getAll() {
        
        return repositorio.findAll();
    }
    
    @Override
    public Cidade save(Cidade cidade){
        return repositorio.save(cidade);
    }
    
    @Override
    public Cidade findById(long id){

        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Cidade();
    }

    @Override
    public void delete(long id) {
       repositorio.deleteById(id);
    }

    /*@Override
    public Cidade delete(Cidade cidade){
        return repositorio.delete(cidade);    
    }
    */
}
