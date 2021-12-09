package jogowar.domain;

import java.util.Random;

public class Dado {

    private static Dado instancia;

    private Dado(){}

    public static Dado obtemInstancia() {
        if (instancia == null){
            instancia = new Dado();
        }
        return instancia;
    }

    public int rodar() {
        var menorValor = 1;
        var maiorValor = 6;
        return new Random().nextInt(maiorValor) + menorValor;
    }
}
