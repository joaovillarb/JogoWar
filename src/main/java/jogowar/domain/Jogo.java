package jogowar.domain;

import java.util.List;

public class Jogo {

    private Dado dado;
    private List<Jogador> jogadores;

    public Jogo(Dado dado, List<Jogador> jogadores) {
        this.dado = dado;
        this.jogadores = jogadores;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public boolean inicializaRodada(){
        if (dado != null && jogadores.size() >= 4)
            return true;
        throw new IllegalArgumentException("QUANTIDADE DE JOGARES MENOR QUE 4");
    }
}
