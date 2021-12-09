package jogowar.exceptions;

public class QuantidadeJogadoresException extends IllegalStateException {
	private final static String menssagem = "QUANTIDADE DE JOGARES MENOR QUE 3";
	
    public QuantidadeJogadoresException() {
        super(menssagem);
    }
}
