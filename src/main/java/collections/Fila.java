package collections;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Thiago");
        fila.offer("Amanda");
        fila.offer("Julio");
        fila.offer("Bruna");

        // peek and element get the first element of queue, but it does not remove them
        // when the maximum queue limit has been achieved the peek method return null and element method throws error (NoSuchElementException)
        String name = fila.peek();
        String name1 = fila.element();
        String name2 = fila.element();
        String name3 = fila.peek();

        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

        // poll and remove return de first element of queue but remove the item before retrieve it
        // when does not have more items the poll method return false and remove method throws error (NoSuchElementException)
        String first = fila.poll();
        String second = fila.remove();
        String third = fila.remove();
        String fiv = fila.element();

        System.out.println(fila.size());
    }
}
