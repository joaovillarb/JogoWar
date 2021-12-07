package jogowar.domain.dado;

import java.util.Random;

public class Dado {
    public int rodar() {
        var menorValor = 1;
        var maiorValor = 6;
        return new Random().nextInt(maiorValor) + menorValor;
    }
}
