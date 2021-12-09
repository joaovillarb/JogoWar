package jogowar.domain.jogador;

import jogowar.domain.Carta;
import jogowar.domain.Cor;
import jogowar.domain.Territorio;
import jogowar.domain.objetivo.Objetivo;

import java.util.List;

public class JogadorBuilder {
    private final Jogador jogador;

    public JogadorBuilder() {
        this.jogador = new Jogador();
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }

    public JogadorBuilder addNome(String nome) {
        this.jogador.setNome(nome);
        return this;
    }

    public JogadorBuilder addCor(Cor cor) {
        this.jogador.setCor(cor);
        return this;
    }

    public JogadorBuilder addObjetivo(Objetivo objetivo) {
        this.jogador.setObjetivo(objetivo);
        return this;
    }

    public JogadorBuilder addCartas(List<Carta> cartas) {
        this.jogador.setCartas(cartas);
        return this;
    }

    public JogadorBuilder addTerritorios(List<Territorio> territorios) {
        this.jogador.setTerritorios(territorios);
        return this;
    }

    public Jogador build() {
        return this.jogador;
    }
}
