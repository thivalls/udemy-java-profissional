package br.com.game.campominado.entities;

import br.com.game.campominado.exceptions.ExplosaoException;

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

    void marcar() {
        if (!aberto) {
            marcado = !marcado;
        }
    }

    boolean abrir() {
        if(!marcado && !aberto) {
            aberto = true;

            if (minado) {
                throw new ExplosaoException("Campo minado... você perdeu");
            }

            if (vizinhancaSegura()) {
                vizinhos.forEach(Campo::abrir);
            }

            return true;
        }

        return false;
    }

    boolean vizinhancaSegura() {
        return vizinhos.stream().noneMatch(vizinho -> vizinho.minado);
    }

    void minar() {
        if(!minado) {
            minado = true;
        }
    }

    public boolean isMarcado() {
        return marcado;
    }

    public boolean isMinado() {
        return minado;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return !isAberto();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetivoAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    long minasNaVizinhanca() {
        return vizinhos.stream().filter(vizinho -> vizinho.minado).count();
    }

    void reiniciar() {
        aberto = false;
        minado = false;
        marcado = false;
    }

    public String toString() {
        if (marcado) {
            return "@";
        } else if(aberto && minado) {
            return "*";
        } else if (aberto && minasNaVizinhanca() > 0) {
            return Long.toString(minasNaVizinhanca());
        } else if (aberto) {
            return "";
        } else {
            return "?";
        }
    }
}
