package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//stream working with collection
public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Yanan", "Sun", 1), new Person("Pa", "Pu", 2), new Person("C", "C", 1));
        // people.stream().forEach(p -> System.out.println(p.getFirstName()));
        people.stream().filter(p->p.getLastName().startsWith("C")).forEach(p -> System.out.println(p.getFirstName()));
        List<Person> people1 = people.stream().filter(p->p.getLastName().startsWith("C")).collect(Collectors.toList());
        people.parallelStream().filter(p->p.getLastName().startsWith("C")).collect(Collectors.toList());
    }
}
