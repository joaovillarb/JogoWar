package jogowar.exceptions;

public class TerritoriosNaoAdjacentesException extends IllegalStateException {
	private final static String menssagem = "TERRITORIO ATACANTE NAO FAZ FRONTEIRA COM O DEFENSOR";
	
    public TerritoriosNaoAdjacentesException() {
        super(menssagem);
    }
}
