package jogowar.domain;

import java.util.Random;

public enum Cor {
    PRETO, VERDE, AZUL, VERMELHO, BRANCO, AMARELO;

    public static Cor sortear() {
        var indice = new Random().nextInt(Cor.values().length);
        return Cor.values()[indice];
    }
}
