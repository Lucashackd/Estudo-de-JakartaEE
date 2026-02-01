package br.com.procergs;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    private PessoaService service; // Agora falamos com o "gerente" (EJB)

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String dizerOla() {
        // Cria um objeto Java
        Pessoa p = new Pessoa("usuario via api", "Testador REST");

        // Manda pro banco
        service.cadastrarNovaPessoa(p);

        return "Sucesso! A pessoa " + p.getNome() + " com ID " + p.getId() + " foi salva no banco H2 via EJB.";
    }
}
