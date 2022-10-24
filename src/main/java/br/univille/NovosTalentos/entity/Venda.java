package br.univille.NovosTalentos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    
    

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cliente comprador;
    
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<ItemVenda> colItens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<ItemVenda> getColItens() {
        return colItens;
    }

    public void setColItens(List<ItemVenda> colItens) {
        this.colItens = colItens;
    }

    
}
