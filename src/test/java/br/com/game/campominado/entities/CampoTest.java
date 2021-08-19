package br.com.game.campominado.entities;

import br.com.game.campominado.exceptions.ExplosaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CampoTest {

    private Campo campo;

    @BeforeEach
    void setUp() {
        campo = new Campo(3, 3);
    }

    @Test
    @DisplayName("Deve retornar true para o campo de cima")
    void test1() {
        Campo vizinho = new Campo(2, 3);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campo de baixo")
    void test2() {
        Campo vizinho = new Campo(4, 3);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campo da direita")
    void test3() {
        Campo vizinho = new Campo(3, 4);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campo da esquerda")
    void test4() {
        Campo vizinho = new Campo(3, 2);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campos da diagonal superior direita")
    void test5() {
        Campo vizinho = new Campo(2, 4);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campos da diagonal superior esquerda")
    void test6() {
        Campo vizinho = new Campo(2, 2);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campos da diagonal inferior direita")
    void test7() {
        Campo vizinho = new Campo(4, 4);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar true para o campos da diagonal superior esquerda")
    void test8() {
        Campo vizinho = new Campo(4, 2);
        assertTrue(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar false para o campos que não são vizinhos")
    void test9() {
        Campo vizinho = new Campo(7, 8);
        assertFalse(campo.checarVizinho(vizinho));
    }

    @Test
    @DisplayName("Deve retornar false quando pelo menos um vizinho esteja minado")
    void test10() {
        Campo vizinho1 = new Campo(2, 2);
        Campo vizinho2 = new Campo(2, 3);
        Campo vizinho3 = new Campo(2, 4);
        Campo vizinho4 = new Campo(3, 2);
        Campo vizinho5 = new Campo(3, 4);
        Campo vizinho6 = new Campo(4, 2);
        Campo vizinho7 = new Campo(4, 3);
        Campo vizinho8 = new Campo(4, 4);

        vizinho3.minar();

        campo.adicionarVizinho(vizinho1);
        campo.adicionarVizinho(vizinho2);
        campo.adicionarVizinho(vizinho3);
        campo.adicionarVizinho(vizinho4);
        campo.adicionarVizinho(vizinho5);
        campo.adicionarVizinho(vizinho6);
        campo.adicionarVizinho(vizinho7);
        campo.adicionarVizinho(vizinho8);

        assertFalse(campo.vizinhancaSegura());
    }

    @Test
    @DisplayName("Deve retornar true quando pelo menos um vizinho esteja minado")
    void test11() {
        Campo vizinho1 = new Campo(2, 2);
        Campo vizinho2 = new Campo(2, 3);
        Campo vizinho3 = new Campo(2, 4);
        Campo vizinho4 = new Campo(3, 2);
        Campo vizinho5 = new Campo(3, 4);
        Campo vizinho6 = new Campo(4, 2);
        Campo vizinho7 = new Campo(4, 3);
        Campo vizinho8 = new Campo(4, 4);

        campo.adicionarVizinho(vizinho1);
        campo.adicionarVizinho(vizinho2);
        campo.adicionarVizinho(vizinho3);
        campo.adicionarVizinho(vizinho4);
        campo.adicionarVizinho(vizinho5);
        campo.adicionarVizinho(vizinho6);
        campo.adicionarVizinho(vizinho7);
        campo.adicionarVizinho(vizinho8);

        assertTrue(campo.vizinhancaSegura());
    }

    @Test
    @DisplayName("Deve retornar false por valor padrão do campo marcado")
    void test12() {
        assertFalse(campo.isMarcado());
    }

    @Test
    @DisplayName("Deve marcar um campo como seguro")
    void test13() {
        campo.marcar();
        assertTrue(campo.isMarcado());
    }

    @ParameterizedTest
    // @CsvSource("{'2', '4', '6', '8', '10'}")
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Deve retornar true quando acionar o método marcar uma quantidade par de vezes")
    void test14(int ints) {
        for (int i = 1; i <= ints; i++) {
            campo.marcar();
        }
        assertFalse(campo.isMarcado());
    }

    @ParameterizedTest
    // @CsvSource("{'2', '4', '6', '8', '10'}")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("Deve retornar true quando acionar o método marcar uma quantidade impar de vezes")
    void test15(int ints) {
        for (int i = 1; i <= ints; i++) {
            campo.marcar();
        }
        assertTrue(campo.isMarcado());
    }

    @Test
    @DisplayName("Deve retornar true quando tentar abrir um campo não minado")
    void test16() {
        assertTrue(campo.abrir());
    }

    @Test
    @DisplayName("Deve retornar true quando tentar abrir um campo não minado")
    void test17() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> campo.abrir());
    }

    @Test
    @DisplayName("Deve retornar false quando tentar abrir um campo já aberto e não minado")
    void test18() {
        campo.abrir();
        assertFalse(campo.abrir());
    }

    @Test
    @DisplayName("Deve retornar false quando tentar abrir um campo marcado e minado")
    void test19() {
        campo.marcar();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    @DisplayName("Deve abrir todos os vizinhos que não estiverem minados")
    void test20() {
        Campo vizinho1 = new Campo(2, 2);
        Campo vizinho2 = new Campo(2, 3);
        Campo vizinhoDoVizinho2 = new Campo(2, 4);

        vizinho1.adicionarVizinho(vizinho2);
        vizinho2.adicionarVizinho(vizinhoDoVizinho2);

        campo.adicionarVizinho(vizinho1);

        vizinho1.abrir();

        Assertions.assertAll(
                () -> assertTrue(vizinho1.isAberto()),
                () -> assertTrue(vizinho2.isAberto()),
                () -> assertTrue(vizinhoDoVizinho2.isAberto())
        );
    }

    @Test
    @DisplayName("Não deve abrir os vizinhos que estiverem minados")
    void test21() {
        Campo vizinho1 = new Campo(2, 2);
        Campo vizinho2 = new Campo(2, 3);
        Campo vizinhoDoVizinho2 = new Campo(2, 4);

        vizinho1.adicionarVizinho(vizinho2);
        vizinho2.adicionarVizinho(vizinhoDoVizinho2);

        vizinhoDoVizinho2.minar();

        campo.adicionarVizinho(vizinho1);

        vizinho1.abrir();

        Assertions.assertAll(
                () -> assertTrue(vizinho1.isAberto()),
                () -> assertTrue(vizinho2.isAberto()),
                () -> assertFalse(vizinhoDoVizinho2.isAberto())
        );
    }
}