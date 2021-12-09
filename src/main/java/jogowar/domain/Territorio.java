package jogowar.domain;

import jogowar.domain.jogador.Jogador;

import java.util.List;

public class Territorio {
    private final String nome;
    private List<Territorio> adjacentes;
    private Jogador jogador;
    private Exercito exercito;

    public Territorio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Territorio> getAdjacentes() {
        return adjacentes;
    }
    
    public void setAdjacentes(List<Territorio> adjacentes) {
    	this.adjacentes = adjacentes;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Exercito getExercito() {
        return exercito;
    }

    public void setExercito(Exercito exercito) {
        this.exercito = exercito;
    }
}
