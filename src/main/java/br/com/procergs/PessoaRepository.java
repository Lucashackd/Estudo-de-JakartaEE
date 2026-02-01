package br.com.procergs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless // Transformação em EJB
public class PessoaRepository {

    @PersistenceContext(unitName = "procergs-pu") // Injeta o gerente de entidades
    private EntityManager em;

    //Removido o @Transactional
    public void salvar(Pessoa p) {
        em.persist(p);
    }
}
