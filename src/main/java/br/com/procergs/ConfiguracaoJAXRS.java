package br.com.procergs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ConfiguracaoJAXRS extends Application {
    // Só isso. Essa classe avisa o servidor: "Ligue o motor JAX-RS (REST) aqui".
}
