package br.com.procergs;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named // Agora o arquivo .xhtml pode chamar #{pessoaBean}
@ViewScoped // Mantém os dados vivos enquanto você não troca de tela
public class PessoaBean implements Serializable {

    @Inject
    private PessoaService service; // Mudou de Repository para Service

    private Pessoa pessoa = new Pessoa();
    private String mensagem;

    public Pessoa getPessoa() { return pessoa; }

    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    public String getMensagem() { return mensagem; }

    //public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    // Metodo chamado pelo botão "Salvar"
    public void salvar() {
        try {
            service.cadastrarNovaPessoa(pessoa);

            mensagem = "Sucesso! " + pessoa.getNome() + " cadastrado com ID " + pessoa.getId();
            pessoa = new Pessoa();
        } catch (Exception e) {
            mensagem = "Erro ao salvar: " + e.getMessage();
        }
    }
}
