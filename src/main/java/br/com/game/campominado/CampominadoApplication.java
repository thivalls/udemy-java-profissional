package br.com.game.campominado;

import br.com.game.campominado.entities.Tabuleiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampominadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampominadoApplication.class, args);
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

        tabuleiro.abrir(0,0);
        tabuleiro.marcar(1,2);
        tabuleiro.marcar(2,3);

        System.out.println(tabuleiro.toString());
    }

}
