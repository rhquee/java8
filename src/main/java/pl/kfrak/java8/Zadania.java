package pl.kfrak.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-05-15.
 */
public class Zadania {
    public static void main(String[] args) {

        //utworzyc liste od 1 - 100 i wypisac tylko niepatzrsyte
        List<Integer> list100 = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            list100.add(i);
        }
        list100.stream().filter(x -> x % 2 == 1).forEach(x -> System.out.println(x));

        //sortowanie; komparator
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
        System.out.println("matcher");
        boolean isAnyNumberLargerThan5 = list100.stream().anyMatch(x -> x > 5);
        boolean areAllElementsLessThan10 = list100.stream().allMatch(x -> x < 10);
        boolean isThereAnyElementLessThan0 = list100.stream().noneMatch(x -> x < 0);

        //count
        
    }
}


