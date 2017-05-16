package pl.kfrak.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-05-16.
 */
public class LambdaPersons {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Adam", "Nowak", "Wrocław"));
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
                    if (p1.getLastName().compareTo(p2.getLastName()) != 0){
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                    if(p1.getFirstName().compareTo(p2.getFirstName()) != 0){
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


    }
}