package br.com.procergs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class PessoaRepository {

    @PersistenceContext(unitName = "procergs-pu") // Injeta o gerente de entidades
    private EntityManager em;

    // Nota: Sem @Transactional e sem @Stateless(classe)
    // Ele vai "pegar carona" na transação de quem chamar ele.
    public void salvar(Pessoa p) {
        em.persist(p);
    }

    public List<Pessoa> listarTodos() {
        // JPQL: "Selecione p (o objeto inteiro) da classe Pessoa"
        // Nota: Não usamos "SELECT * FROM TAB_PESSOA". Usamos o nome da CLASSE.
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }
}
