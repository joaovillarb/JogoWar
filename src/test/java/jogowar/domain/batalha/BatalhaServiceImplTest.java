package jogowar.domain.batalha;

import jogowar.domain.Cor;
import jogowar.domain.Jogador;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BatalhaServiceImplTest {

    private BatalhaService batalhaService;

    @Nested
    class Ao_atacar {
        @BeforeEach
        void setup() {
            batalhaService = new BatalhaServiceImpl();
        }

        @Test
        void Deve_retornar_um_ganhador() {
//           TODO: da pra criar um builder no jogador
            var atacante = new Jogador("Player 01", Cor.AMARELO);
            var defensor = new Jogador("Player 02", Cor.AZUL);
            batalhaService.atacar(atacante, defensor);
        }
    }
}