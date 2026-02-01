package br.com.procergs;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class PessoaService {

    @Inject
    private PessoaRepository repository;

    public void cadastrarNovaPessoa(Pessoa p) {
        // Regra de Negócio 1: Ninguém pode ter nome vazio
        if (p.getNome() == null || p.getNome().trim().isEmpty()) throw new RuntimeException("O nome é obrigatório");

        // Regra de Negócio 2: Transformar tudo para maiúsculo (padrão da empresa)
        p.setNome(p.getNome().toUpperCase());
        p.setCargo(p.getCargo().toUpperCase());

        // Se passou nas regras, manda o operário salvar
        // A transação do EJB "flui" para dentro do Repoitory automaticamente
        repository.salvar(p);
    }
}
