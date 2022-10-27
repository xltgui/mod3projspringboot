package br.univille.NovosTalentos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.NovosTalentos.entity.Cliente;
import br.univille.NovosTalentos.service.ClienteService;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteControllerAPI {
    @Autowired
    private ClienteService service;
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        var listaClientes = service.getAll();
        return new ResponseEntity<>(listaClientes,HttpStatus.OK);
    }
}
