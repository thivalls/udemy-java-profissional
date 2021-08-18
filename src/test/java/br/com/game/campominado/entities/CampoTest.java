package br.com.game.campominado.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}