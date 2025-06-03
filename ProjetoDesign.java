package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;

public class ProjetoDesign {
    private String nome;
    private String cliente;
    private List<Designer> observers = new ArrayList<>();

    public ProjetoDesign(String nome, String cliente) {
        this.nome = nome;
        this.cliente = cliente;
    }

    public void adicionarObserver(Designer designer) {
        observers.add(designer);
    }

    public void publicarFeedback() {
        for (Designer d : observers) {
            d.receberNotificacao(this);
        }
    }

    @Override
    public String toString() {
        return "ProjetoDesign{nome='" + nome + "', cliente='" + cliente + "'}";
    }
}