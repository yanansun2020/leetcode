package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReference2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Yanan", "Sun", 1), new Person("Pa", "Pu", 2), new Person("C", "C", 1));
        sortWithLambda(people);
        //step1 sort by last name

        //step2 print all elements in the list
        //step3 print all people have last name starts with C
    }
    public static void sortWithLambda(List<Person> list) {
        Collections.sort(list, (o1, o2)-> o1.getLastName().compareTo(o2.getLastName()));
        printWithFilterPredicate(list, (p)-> p.getLastName().startsWith("C"), (p)->System.out.println(p.getFirstName()));
        printWithFilterPredicate(list, (p)-> true,  System.out::println); //(p)->method(p)
    }

    public static void printWithFilterPredicate(List<Person> list, Predicate<Person> condition, Consumer<Person> consumer) {
        for (Person p : list) {
            if (condition.test(p)) consumer.accept(p) ;
        }
    }
}
