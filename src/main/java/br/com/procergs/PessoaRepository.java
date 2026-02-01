package br.com.procergs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RequestScoped
public class PessoaRepository {

    @PersistenceContext(unitName = "procergs-pu") // Injeta o gerente de entidades
    private EntityManager em;

    @Transactional
    public void salvar(Pessoa p) {
        em.persist(p);
    }
}
