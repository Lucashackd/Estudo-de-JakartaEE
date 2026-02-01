package br.com.procergs;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named // Agora o arquivo .xhtml pode chamar #{pessoaBean}
@ViewScoped // Mantém os dados vivos enquanto você não troca de tela
public class PessoaBean implements Serializable {

    @Inject
    private PessoaService service; // Mudou de Repository para Service

    private Pessoa pessoa = new Pessoa();
    private String mensagem;

    private List<Pessoa> listaPessoas; // Cache da lista para a tela

    @PostConstruct // Executa logo após o Bean ser criado e as injeções (@Inject) terminarem
    public void inicializar() {
        atualizarLista();
    }

    public void atualizarLista() {
        this.listaPessoas = service.listar();
    }

    // Metodo chamado pelo botão "Salvar"
    // Atualizado para recarregar a lista após gravar
    public void salvar() {
        try {
            service.cadastrarNovaPessoa(pessoa);
            mensagem = "Sucesso! " + pessoa.getNome() + " cadastrado com ID " + pessoa.getId();
            pessoa = new Pessoa();
            atualizarLista();
        } catch (Exception e) {
            mensagem = "Erro ao salvar: " + e.getMessage();
        }
    }

    public Pessoa getPessoa() { return pessoa; }

    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    public String getMensagem() { return mensagem; }

    public List<Pessoa> getListaPessoas() { return listaPessoas; } // Não precisa de Set pois apenas faz a listagem

    //public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
