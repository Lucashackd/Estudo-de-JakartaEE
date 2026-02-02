package br.com.procergs;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pessoas")
public class PessoaResource {

    @Inject
    private PessoaService service; // Agora falamos com o "gerente" (EJB)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> listarTodas() {
        return service.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa salvar(Pessoa p) {
        // EJB vai validar, colocar em caixa alta e salvar
        service.cadastrarNovaPessoa(p);
        return p;
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") Long id) {
        service.excluir(id);
    }
}
