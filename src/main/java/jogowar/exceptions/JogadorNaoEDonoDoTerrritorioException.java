package jogowar.exceptions;

import jogowar.domain.Territorio;
import jogowar.domain.jogador.Jogador;

public class JogadorNaoEDonoDoTerrritorioException extends IllegalStateException {
	private final static String menssagem = "JOGADOR NAO E DONO DE TERRITORIO";
	
    public JogadorNaoEDonoDoTerrritorioException(Territorio territorioG, Jogador jogador) {
        super(menssagem.replaceAll("JOGADOR", jogador.getNome()).replaceAll("TERRITORIO", territorioG.getNome()));
    }
}
