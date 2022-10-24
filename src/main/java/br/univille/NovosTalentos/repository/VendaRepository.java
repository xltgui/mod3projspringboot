package br.univille.NovosTalentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.NovosTalentos.entity.Venda;

@Repository
public interface VendaRepository  extends JpaRepository<Venda, Long> {

}
