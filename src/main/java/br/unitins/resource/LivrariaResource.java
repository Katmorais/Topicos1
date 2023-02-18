package br.unitins.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.unitins.model.Livraria;

// Retorna todos os objetos do banco
@Path("/Livraria")
public class LivrariaResource {
    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
     public List<Livraria> getAllLivro(){
        return Livraria.findAll().list();
     }

     @POST
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     @Transactional
     public Livraria insert(Livraria livraria){
        livraria.persist();
        return livraria;

     }
}
