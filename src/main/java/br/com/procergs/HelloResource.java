package br.com.procergs;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    private PessoaRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String dizerOla() {
        // Cria um objeto Java
        Pessoa p = new Pessoa("Desenvolvedor Procergs", "Full Stack Java");

        // Manda pro banco
        repository.salvar(p);

        return "Sucesso! A pessoa com ID " + p.getId() + " foi salva no banco H2.";
    }
}
