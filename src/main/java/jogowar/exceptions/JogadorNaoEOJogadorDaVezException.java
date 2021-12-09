package jogowar.exceptions;

public class JogadorNaoEOJogadorDaVezException extends IllegalStateException {
	private final static String menssagem = "JOGADOR ATACANTE NAO E O JOGADOR DA VEZ";
	
    public JogadorNaoEOJogadorDaVezException() {
        super(menssagem);
    }
}
