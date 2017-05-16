package pl.kfrak.java8;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by RENT on 2017-05-16.
 */
public class Maps {
    public static void main(String[] args) {
        Map<String, String> exampleMap = new HashMap<>();

        // dodawanie do mapy
        exampleMap.put("abc", "Adam Kowalski");
        exampleMap.put("2", "Piotr Nowak");

        // wyciąganie z mapy
        String valueFromKey1 = exampleMap.get("abc");
        System.out.println(valueFromKey1);

        String valueFromKey2 = exampleMap.get("2");
        System.out.println(valueFromKey2);

        /////////////////////////
        List<String> list = new ArrayList<>();
        list.add("Piotr");
        list.add("Adam");

        System.out.println("LIST CONTENT");
        for (String elem : list) {
            System.out.println(elem);
        }

        Set<Point> listOfPoints = new HashSet<>();
        listOfPoints.add(new Point(5, 3));
        listOfPoints.add(new Point(10, 7));

        for (Point elem : listOfPoints) {
            System.out.println("Punkt o X: " + elem.getX());
            System.out.println("Punkt o Y: " + elem.getY());
        }

        // iterowanie po mapie
        Set<Map.Entry<String, String>> entries = exampleMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("KLUCZ: " + entry.getKey());
            System.out.println("WARTOSC: " + entry.getValue());
        }

        Map<String, List<Person>> personsMap = new HashMap<>();

        List<Person> people = new ArrayList<>();
        people.add(new Person("Adam", "Kowalski", "Wrocław"));
        people.add(new Person("Adam", "Nowak", "Warszawa"));

        personsMap.put("a", people);

        Set<Map.Entry<String, List<Person>>> entries1 = personsMap.entrySet();
        for (Map.Entry<String, List<Person>> entry : entries1) {
            String key = entry.getKey();
            System.out.println("Key " + key);
            List<Person> value = entry.getValue();
            System.out.println("Value: " + value);
        }

        // wyciąganie kluczy z mapy
        Set<String> strings = personsMap.keySet();

        // wyciąganie wartości
        Collection<List<Person>> values = personsMap.values();
        for (List<Person> value : values) {

        }

    }
}