package jogowar.domain.jogador;

import jogowar.domain.Carta;
import jogowar.domain.Cor;
import jogowar.domain.Territorio;
import jogowar.domain.objetivo.Objetivo;

import java.util.List;

public class Jogador {
    private String nome;
    private Cor cor;
    private Objetivo objetivo;
    private List<Carta> cartas;
    private List<Territorio> territorios;

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
