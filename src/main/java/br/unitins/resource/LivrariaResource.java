package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
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
import br.unitins.repository.LivrariaRepository;

@Path("/Livraria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivrariaResource {
   @Inject
   private LivrariaRepository repository;
   // Permitir consultar todos
   @GET
   @Path("/todos")
   public List<Livraria> getAllLivro() {
      return repository.findAll().list();
   }
   // Permite incluir
   @POST
   @Transactional
   public Livraria insert(Livraria livraria) {
      repository.persist(livraria);
      return livraria;

   }
   // Altera o objeto inteiro
   @PUT
   @Path("/{id}")
   @Transactional
   public Livraria atualizar(@PathParam("id") Long id, Livraria livraria) {
      Livraria livrariaId = repository.findById(id);
      livrariaId.setNomeLivro(livraria.getNomeLivro());
      livrariaId.setAutor(livraria.getAutor());
      livrariaId.setEditora(livraria.getEditora());
      livrariaId.setAnoLancamento(livraria.getAnoLancamento());
      livrariaId.setEstoque(livraria.getEstoque());
      return livrariaId;

   }
   // Permite consultar por id
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Livraria buscarId(@PathParam("id") Long id){
      return repository.findById(id);
   }

   // Permite alterar parcialmente
   @PATCH
   @Path("/{id}")
   @Transactional
   public Livraria atualizarParcialmente(@PathParam("id") Long id, Livraria livraria) {
      Livraria livrariaId = repository.findById(id);
      livrariaId.setNomeLivro(livraria.getNomeLivro());
      livrariaId.setAutor(livraria.getAutor());
      return livrariaId;
   }

   // Deleta por nome
  @DELETE
  @Path("/{nomeLivro}")
  @Transactional
  public Livraria deletarNome(@PathParam("nomeLivro") String nomeLivro){
      Livraria livrariaDeletar = repository.findByName(nomeLivro);
      repository.delete(livrariaDeletar);
      return livrariaDeletar;
      
  }
   // Delete por id
   @DELETE
   @Path("/{id}")
   @Transactional
   public Livraria deletar(@PathParam("id") long id, Livraria livraria) {
      Livraria livrariaId = repository.findById(id);
      repository.delete(livraria);
      return livrariaId;
      
   }
   // Permite consultar por nome
   @GET
   @Path("/buscar/{nomeLivro}")
   public Livraria buscarNome(@PathParam("nomeLivro")String nomeLivro){
      return repository.findByName(nomeLivro);
   }

   // Busca uma lista de resultados
   @GET
   @Path("/{nomeLivro}")
   public List<Livraria> buscarListaLivros(@PathParam("nomeLivro") String nomeLivro){
      return repository.findByNomeList(nomeLivro);

   }
   
}
