package jogowar.domain;

public class Carta {
    private final String nome;
    private final String simbolo;

    public Carta(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
