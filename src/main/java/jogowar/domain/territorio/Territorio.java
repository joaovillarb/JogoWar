package jogowar.domain.territorio;

import jogowar.domain.Exercito;
import jogowar.domain.Jogador;

import java.util.List;

public class Territorio {
    private final String nome;
    private final List<Territorio> adjacentes;
    private Jogador jogador;
    private Exercito exercito;

    public Territorio(String nome, List<Territorio> adjacentes) {
        this.nome = nome;
        this.adjacentes = adjacentes;
    }

    public String getNome() {
        return nome;
    }

    public List<Territorio> getAdjacentes() {
        return adjacentes;
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
