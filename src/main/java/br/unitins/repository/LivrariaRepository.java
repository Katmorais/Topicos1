package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Livraria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LivrariaRepository implements PanacheRepository <Livraria> {
    public Livraria findByName(String nomeLivroString){
        return find("nomeLivro", nomeLivroString).firstResult();

    }
    public List<Livraria> findByNomeList(String nomeLivro){
        return find("nomeLivro Like ?1" ,"%" + nomeLivro + "%").list();

    }
    
}
