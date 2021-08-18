package br.com.game.campominado.entities;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean checarVizinho(Campo campo) {
        int calc = Math.abs(this.linha - campo.linha) + Math.abs(this.coluna - campo.coluna);
        return calc == 1 || calc == 2;
    }

    void adicionarVizinho(Campo campo) {
        if (this.checarVizinho(campo)) {
            vizinhos.add(campo);
        }
    }
}
