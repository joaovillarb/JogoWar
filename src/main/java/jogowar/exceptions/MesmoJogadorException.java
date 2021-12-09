package jogowar.exceptions;

public class MesmoJogadorException extends IllegalStateException {
	private final static String menssagem = "JOGADOR ATACANTE E O MESMO QUE O DEFENSOR";
	
    public MesmoJogadorException() {
        super(menssagem);
    }
}
