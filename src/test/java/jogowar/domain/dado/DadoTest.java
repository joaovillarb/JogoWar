package jogowar.domain.dado;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DadoTest {

    private Dado dado;

    @Nested
    class Ao_jogar_dado {
        @BeforeEach
        void setup() {
            dado = new Dado();
        }

        @Test
        void Deve_gerar_um_numero_entre_1_e_6() {
            final int maior = 6;
            final int menor = 1;
            int random = dado.rodar();
            assertTrue(maior >= random);
            assertTrue(menor <= random);
        }
    }
}