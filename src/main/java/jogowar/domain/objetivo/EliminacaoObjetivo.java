package jogowar.domain.objetivo;

import jogowar.domain.Cor;

public class EliminacaoObjetivo extends Objetivo {

    private final Cor corAlvo;

    public EliminacaoObjetivo(Cor corAlvo) {
        this.corAlvo = corAlvo;
        setDescricao("Destruir exércitos " + corAlvo);
    }

    @Override
    public boolean isCompleto() {
        return false;
    }
}
