package pl.kfrak.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by RENT on 2017-05-15.
 */
//public class Streams {
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(5);
//        list.add(4);
//        list.add(10);
//        list.add(3);
//
////        list.stream()
////                .forEach(new Consumer<Integer>() {
////                    @Override
////                    public void accept(Integer integer) {
////                        System.out.println(integer);
////                    }
////                });
//        //to jest lambda - ladniejszy zapis interfejsu funkcyjnego (ktory ma 1 metode zeby cos wykonac)
//        //po lewej stronie strzalki argumenty metosy, po prawej - to co sie dzieje w tej metodzie
//        list.stream().forEach(x -> System.out.println(x));
//
//        //a jakbysmy chcieli wypisac dwa rayz to z klamrami, albo <1 argumenty
//        list.stream().forEach( (x, y) -> {
//            System.out.println(x);
//            System.out.println("twice" + x);});


        public class Streams {
            public static void main(String[] args) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                list.add(5);
                list.add(4);
                list.add(10);
                list.add(3);


                //zamiana listy(kolekcji) na strumien
                list.stream();

                //zamiana tablicy na strumien
                int[] array = new int[10];
                Arrays.stream(array);


                //z uzyciem klasy anonimowej
                list.stream()
                        .forEach(
                                new Consumer<Integer>() {
                                    @Override
                                    public void accept(Integer integer) {
                                        System.out.println(integer);
                                    }
                                }
                        );


                //z uzyciem lambdy = lukier syntaktyczny - cos ladnie zapisane (ladny sposob zapisania)
                list.stream().forEach(x -> System.out.println(x));


                list.stream()
                        .forEach(
                                new Consumer<Integer>() {
                                    @Override
                                    public void accept(Integer integer) {
                                        System.out.println(integer);
                                        System.out.println("Twice:" + integer);
                                    }
                                }
                        );

                list.stream().forEach(x -> {
                    System.out.println(x);
                    System.out.println("Twice:" + x);
                });

                for (Integer integer : list) {
                    System.out.println(integer);
                    System.out.println("Twice:" + integer);
                }

                list.stream().forEach(x -> {
                    System.out.println(x);
                    System.out.println("Twice:" + x);
                });

                list.forEach(x -> System.out.println(x));

                list.forEach(System.out::println);

                // FILTROWANIE
                System.out.println("Przefiltrowany strumień");

                list.stream().filter(x -> x >= 5).forEach(x -> System.out.println(x));

                // to samo bez lambd
                list.stream().filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer > 10;
                    }
                }).forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
            }

            public static void consume(MyConsumer myConsumer) {
                double x = 20;
                double multiply = myConsumer.multiply(x);
                System.out.println("Multiplied: " + multiply);
            }
        }

