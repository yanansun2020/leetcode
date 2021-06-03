package java8;

import java.util.Arrays;
import java.util.List;

public class CollectionIterate {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Yanan", "Sun", 1), new Person("Pa", "Pu", 2), new Person("C", "C", 1));
        //internal iteration
        people.forEach((p)-> System.out.println(p));
        people.forEach(System.out::println);
    }
}
