package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Pilha {
    public static void main(String[] args) {
        Deque<String> pilha = new ArrayDeque<>();

        pilha.add("Dom Queixote");
        pilha.push("O Hobbit");
        pilha.push("Pequeno Príncipe");
        pilha.push("O Guarani");

        for(String livro: pilha) {
            System.out.println(livro);
        }
        
        // peek and element get the first element of queue, but it does not remove them
        // when the maximum queue limit has been achieved the peek method return null and element method throws error (NoSuchElementException)
        String name = pilha.peek();
        String name1 = pilha.element();
        String name2 = pilha.element();
        String name3 = pilha.peek();

        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

        // poll and remove return de first element of queue but remove the item before retrieve it
        // when does not have more items the poll method return false and remove method throws error (NoSuchElementException)
        String first = pilha.poll(); // if there is no elements it returns null
        String second = pilha.remove();
        String third = pilha.remove(); // if there is no elements it throws error (NoSuchElementException)
        String fourth = pilha.pop();
        String fiv = pilha.poll(); // if there is no elements it throws error (NoSuchElementException)
        System.out.println(fiv);

        System.out.println(pilha.size());
    }
}
