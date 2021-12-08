package jogowar.domain.batalha;

import jogowar.domain.Jogador;

public interface BatalhaService {

    Jogador atacar(Jogador atacante, Jogador defensor);

}
