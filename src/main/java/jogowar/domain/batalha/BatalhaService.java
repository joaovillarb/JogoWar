package jogowar.domain.batalha;

import jogowar.domain.jogador.Jogador;

public interface BatalhaService {

    Jogador atacar(Jogador atacante, Jogador defensor);

}
