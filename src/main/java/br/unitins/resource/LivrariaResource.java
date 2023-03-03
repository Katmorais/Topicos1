package br.unitins.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.unitins.model.Livraria;

@Path("/Livraria")
public class LivrariaResource {
   // Retorna todos os objetos do banco
   @GET
   @Path("/todos")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Livraria> getAllLivro() {
      return Livraria.findAll().list();
   }

   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Transactional
   public Livraria insert(Livraria livraria) {
      livraria.persist();
      return livraria;

   }

   // @Path recurso
   // @PATCH atualiza parcialmente
   // @PUT exige que todo objeto seja atualizado


   @PUT
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Transactional
   public Livraria atualizar(@PathParam("id") Long id, Livraria livraria) {
      Livraria livrariaId = Livraria.findById(id);
      livrariaId.setNomeLivro(livraria.getNomeLivro());
      livrariaId.setAutor(livraria.getAutor());
      livrariaId.setEditora(livraria.getEditora());
      livrariaId.setAnoLancamento(livraria.getAnoLancamento());
      livrariaId.setEstoque(livraria.getEstoque());

      return livrariaId;

   }
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Livraria buscarId(@PathParam("id") Long id){
      
      return Livraria.findById(id);
   }

   @PATCH
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Transactional
   public Livraria atualizarParcialmente(@PathParam("id") Long id, Livraria livraria) {
      Livraria livrariaId = Livraria.findById(id);
      livrariaId.setNomeLivro(livraria.getNomeLivro());
      livrariaId.setAutor(livraria.getAutor());

      return livrariaId;
   }




   @DELETE
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Transactional
   public Livraria deletar(@PathParam("id") long id, Livraria livraria) {
      Livraria livrariaId = Livraria.findById(id);
      livrariaId.delete();
      return livrariaId;

   }

}
