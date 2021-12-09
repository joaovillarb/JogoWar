package jogowar.domain;

import jogowar.domain.jogador.Jogador;
import jogowar.exceptions.QuantidadeJogadoresException;

import java.util.List;

public class Jogo {

    private final Dado dado;
    private final List<Jogador> jogadores;

    public Jogo(Dado dado, List<Jogador> jogadores) {
        this.dado = dado;
        this.jogadores = jogadores;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public boolean inicializaRodada() {
        if (dado != null && jogadores.size() >= 3)
            return true;
        throw new QuantidadeJogadoresException("QUANTIDADE DE JOGARES MENOR QUE 3");
    }
}
