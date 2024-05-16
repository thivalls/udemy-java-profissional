package collections;

import java.util.*;

public class SetApplication {
    public static void main(String[] args) {
        // Sem ordenação e sem tipagem
        HashSet conjunto = new HashSet();

        conjunto.add(1.2);
        conjunto.add(true);
        conjunto.add("teste");

        System.out.println("Total de itens do hash " + conjunto.size());

        // sem ordenação com tipagem
        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println(numeros);

        // com ordenação com tipagem
        // Set<String> names = new HashSet<>();
        // Set<String> names = new LinkedHashSet<>(); RESPEITA ORDEM DE ADIÇÃO
        SortedSet<String> names = new TreeSet<>();
        names.add("Thiago");
        names.add("Valls");
        names.add("Bertolino");

        for (String name: names) {
            System.out.println(name);
        }
    }
}
