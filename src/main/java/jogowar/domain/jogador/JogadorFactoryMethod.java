package jogowar.domain.jogador;

import jogowar.domain.Cor;

public class JogadorFactoryMethod {

    public Jogador fabricarJogador(String nome, Cor cor){
        return new JogadorBuilder().addNome(nome).addCor(cor).build();
    }
}
