package pl.kfrak.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-05-16.
 */
public class LambdaPersons {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Adam", "Nowak", "Wrocław"));
        personList.add(new Person("Adam", "Nowak2", "Wrocław"));
        personList.add(new Person("Adam", "Kowalski", "Warszawa"));
        personList.add(new Person("Jerzy", "Polański", "Warszawa"));
        personList.add(new Person("Piotr", "Mickiewicz", "Sosnowiec"));
        personList.add(new Person("Jan", "Kowalski", "Wrocław"));


        // WYPISANIE TYLKO OSÓB Z WARSZAWY
//        List<Person> personFromWarsaw = new ArrayList<>();
//        for (int i = 0; i < personList.size() ; i++) {
//            personFromWarsaw.add(i)
//        }

        List<Person> personFromWarsaw = personList.stream().filter(x -> x.getCity().equals("Warszawa")).collect(Collectors.toList());
        System.out.println(personFromWarsaw);

        //lub
        // personList.stream().filter(x -> x.getCity().equals("Warszawa")).forEach(x -> System.out.println(x));

        //wypisanie osob z warszawy w formacie NAZWISKO, Imie, Miasto
        personList.stream()
                .filter(p -> p.getCity().equals("Warszawa"))
                .map(p -> p.getLastName().toUpperCase() + " " + p.getFirstName() + " " + p.getCity())
                .forEach(x -> System.out.println(x));

        //posortowac osoby po nazwiskach i wypisac
        personList.stream().
                sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()))
                .forEach(x -> System.out.println(x));

        //posortowac osoby po 1) nazwisku, 2) imieniu, 3) miescie
        System.out.println("sortowanko");
        personList.stream()
                .sorted((p1, p2) -> {
//                    if (!p1.getLastName().equals(p2.getLastName())){
//                        return p1.getLastName().compareTo(p2.getLastName());
//                    }
                    if (p1.getLastName().compareTo(p2.getLastName()) != 0) {
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                    if (p1.getFirstName().compareTo(p2.getFirstName()) != 0) {
                        return p1.getFirstName().compareTo(p2.getFirstName());
                    }
                    return p1.getCity().compareTo(p2.getCity());
                })
                .forEach(x -> System.out.println(x));

        //z uzyciem kolektora joining wypisac
        //START
        //Adam Kowalski
        //...
        //Piotr Kowalski
        //KONIEC

        System.out.println("joining");
        String result2 = personList.stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .map(value -> "" + value)
                .collect(Collectors.joining("" + "\n", "START" + "\n", "\n" + "KONIEC"));
        System.out.println(result2);


        //z uzyciem summary statistic podac srednia dlugosc nazwisk osob
        System.out.println("srednia dlugosc nazwiska");
        IntSummaryStatistics intSummaryStatistics = personList.stream().mapToInt(value -> value.getLastName().length()).summaryStatistics();
        double avg = intSummaryStatistics.getAverage();
        System.out.println(avg);

        //wyspisac osoby w postaci:
        //WARSZAWA
        //Adam Kowalski
        //Wrocław
        //Basia Basiowska
        //Kasia Kasiowska
        //...

        //rozwiazanie 1
        Map<String, List<Person>> citiesPeopleMap = personList.stream().collect(Collectors.groupingBy(p -> p.getCity()));
        Set<Map.Entry<String, List<Person>>> entries = citiesPeopleMap.entrySet();
        for (Map.Entry<String, List<Person>> entry : entries) {
            System.out.println("KLUCZ: " + entry.getKey().toUpperCase());

            List<Person> people = entry.getValue();
            for (Person person : people) {
                System.out.println("\t" + person.getFirstName() + " " + person.getLastName());
            }
        }

        //rozwiazanie 2 - lambdami
        citiesPeopleMap.forEach((key, value) -> {
            System.out.println(key.toUpperCase());
            value.forEach(p -> System.out.println("\t" + p.getFirstName() + " " + p.getLastName()));
        });

        //rozwiazanie 3 - collector
        personList.stream()
                .collect(Collectors.groupingBy(p -> p.getCity()))
                .forEach((key, value) -> {
                    System.out.println(key.toUpperCase());
                    value.forEach(p -> System.out.println("\t" + p.getFirstName() + " " + p.getLastName()));
                });

        //wypisac:
        //Wroclaw -> 2 osoby
        //Warszawa -> 3 osoby

        personList.stream()
                .collect(Collectors.groupingBy(p -> p.getCity()))
                .forEach((key, value) -> {
                    System.out.println(key);
                    System.out.println("osób: " + value.size());
                });

//        value.forEach(p ->  personList.stream().filter(x -> x.getCity().equals(key).count();

        //unikalne imiona + z ilu miast
        //Adam -> 2 miasta
        //Piotr -> 1 miasto
        System.out.println("------unikalne imiona + z ilu miast");
        personList.stream()
                .collect(Collectors.groupingBy(p -> p.getFirstName().toUpperCase()))
                .forEach((names, cities) -> {
                    System.out.println(names);
                   long citiesNumber = cities.stream().map(p -> p.getCity()).distinct().count(); //tu java wie ze chodzi o miasta
                    System.out.println("z miast: " + citiesNumber);
//                    System.out.println("z miast: " + cities.size()); //tu java nie wie ze chodzi o miasta!
                });



    }
}