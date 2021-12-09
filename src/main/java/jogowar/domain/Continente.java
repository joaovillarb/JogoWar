package jogowar.domain;

import jogowar.domain.jogador.Jogador;

import java.util.List;

public class Continente {
    private final String nome;
    private final List<Territorio> territorios;
    private int bonus;
    private Jogador jogador;

    public Continente(String nome, List<Territorio> territorios) {
        this.nome = nome;
        this.territorios = territorios;
    }

    public String getNome() {
        return nome;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
