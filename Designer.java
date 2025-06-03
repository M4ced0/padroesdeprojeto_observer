package padroescomportamentais.observer;

public class Designer {
    private String nome;
    private String ultimaNotificacao;

    public Designer(String nome) {
        this.nome = nome;
    }

    public void inscrever(ProjetoDesign projeto) {
        projeto.adicionarObserver(this);
    }

    public void receberNotificacao(ProjetoDesign projeto) {
        this.ultimaNotificacao = this.nome + ", novo feedback publicado no " + projeto.toString();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}