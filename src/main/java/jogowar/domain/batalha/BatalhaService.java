package jogowar.domain.batalha;

import jogowar.domain.Dado;
import jogowar.domain.Jogo;
import jogowar.domain.Territorio;
import jogowar.domain.jogador.Jogador;

public interface BatalhaService {

    Jogador atacar(Jogo jogo, Territorio Atacante, Territorio Defensor, Dado dado, Jogador atacante, Jogador defensor);

}
