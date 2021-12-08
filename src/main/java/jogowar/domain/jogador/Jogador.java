package jogowar.domain.jogador;

import jogowar.domain.carta.Carta;
import jogowar.domain.cor.Cor;
import jogowar.domain.objetivo.Objetivo;
import jogowar.domain.territorio.Territorio;

import java.util.List;

public class Jogador {
    private String nome;
    private Cor cor;
    private Objetivo objetivo;
    private List<Carta> cartas;
    private List<Territorio> territorios;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }
}
