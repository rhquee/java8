package pl.kfrak.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-05-15.
 */
public class Zadania {
    public static void main(String[] args) {

        //utworzyc liste od 1 - 100 i wypisac tylko niepatzrsyte
        //klasa generyczna <> (zamknieta ostrymi nawiasami) przechowuje dane o typie t.
        List<Integer> list100 = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            list100.add(i);
        }
        list100.stream().filter(x -> x % 2 == 1).forEach(x -> System.out.println(x));

        //sortowanie:
        // sortowanie domyślne
        list100.stream().sorted().forEach(x -> System.out.println(x));

        // komparator
        System.out.println("sortowanie; komparator");
        list100.stream().sorted((x, y) -> {
            if (x > y) {
                return -1;
            }
            if (x < y) {
                return -1;
            }
            return 0;
        }).forEach(x -> System.out.println(x));

        //matchery
        //zwracaja booleana i zamykaja stryumien
        System.out.println("matcher");
        boolean isAnyNumberLargerThan5 = list100.stream().anyMatch(x -> x > 5);
        boolean areAllElementsLessThan10 = list100.stream().allMatch(x -> x < 10);
        boolean isThereAnyElementLessThan0 = list100.stream().noneMatch(x -> x < 0);

        //count
        long amountLessThan5 = list100.stream().filter(x -> x < 5).count();

        //peek
        //peek robi to samo co forEach ale mozna po nim robic kolejne operacje, a forEach zamyka strumien.
        // Peek
        System.out.println("--- PEEK ---");
        list100.stream()
                .peek(x -> System.out.println(x))
                .filter(x -> x > 4)
                .forEach(x -> System.out.println("Greated than 4: " + x));

        // MAPOWANIE
        System.out.println("--- MAPOWANIE ---");
        list100.stream().map(x -> "Number: " + x).forEach(x -> System.out.println(x));

        // MAX, MIN
        Optional<Integer> max = list100.stream().max((x, y) -> {
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
            return 0;

        });
        Optional<Integer> min = list100.stream().min((x, y) -> {
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
            return 0;

        });

        // COLLECTOR
        List<Integer> collect = list100.stream().filter(x -> x < 5).collect(Collectors.toList());
        Set<Integer> collectSet = list100.stream().filter(x -> x < 5).collect(Collectors.toSet());
        String collect1 = list100.stream().filter(x -> x < 5).map(x -> "" + x).collect(Collectors.joining(","));


    }

}


