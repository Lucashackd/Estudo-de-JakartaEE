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
        if (p.getId() == null) em.persist(p);
        else em.merge(p);
    }

    public List<Pessoa> listarTodos() {
        // JPQL: "Selecione p (o objeto inteiro) da classe Pessoa"
        // Nota: Não usamos "SELECT * FROM TAB_PESSOA". Usamos o nome da CLASSE.
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public void excluir(Long id) {
        // Passo 1: Trazer para o contexto (Managed)
        Pessoa p = em.find(Pessoa.class, id);

        // Passo 2: Se existir, marcar para remoção
        if (p != null) {
            em.remove(p);
        }
    }
}
