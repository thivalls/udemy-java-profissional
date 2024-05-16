package collections;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
        ArrayList<Usuario> lista = new ArrayList<>();

        Usuario u1 = new Usuario(1, "Thiago");
        lista.add(u1);

        lista.add(new Usuario(2, "Amanda"));
        lista.add(new Usuario(3,"Thalita"));
        lista.add(new Usuario(4, "Elisabete"));

        if(!lista.contains(new Usuario(6, "Thiago"))) {
            lista.add(new Usuario(6, "Thiago"));
        }

        if(!lista.contains(new Usuario(5, "João"))) {
            lista.add(new Usuario(5, "João"));
        }

        int index = lista.indexOf(new Usuario(6, "Thiago"));
        if(index > 0) {
            lista.remove(index);
        }

        for(Usuario user: lista) {
            System.out.print(user.id + " - ");
            System.out.println(user.name);
        }
    }
}
