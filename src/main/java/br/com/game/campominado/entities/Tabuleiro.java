package br.com.game.campominado.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
        gerarMinas();
    }

    public void abrir(int linha, int coluna) {
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(Campo::abrir);
    }

    public void marcar(int linha, int coluna) {
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(Campo::marcar);
    }

    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                campos.add(new Campo(linha, coluna));
            }
        }
    }

    private void associarVizinhos() {
        for (Campo campo1 : campos) {
            for (Campo campo2 : campos) {
                campo1.adicionarVizinho(campo2);
            }
        }
    }

    private void gerarMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = Campo::isMinado;
        do {
            minasArmadas = campos.stream().filter(minado).count();
            int aleatorio = (int) (Math.random() * campos.size());
            if (!campos.get(aleatorio).isMinado()) {
                campos.get(aleatorio).minar();
            }
        } while (minasArmadas < minas);
    }

    boolean objetivoAlcancado() {
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }

    public void reiniciar() {
        campos.forEach(Campo::reiniciar);
        gerarMinas();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int loop = 0;
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                output.append(" ");
                output.append(campos.get(loop));
                output.append(" ");
                loop++;
            }
            output.append("\n");
        }
        return output.toString();
    }
}
