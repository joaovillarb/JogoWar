package jogowar.exceptions;

public class MesmoTerritorioException extends IllegalStateException {
	private final static String menssagem = "TERRITORIO ATACANTE E O MESMO QUE DEFENSOR";
	
    public MesmoTerritorioException() {
        super(menssagem);
    }
}
