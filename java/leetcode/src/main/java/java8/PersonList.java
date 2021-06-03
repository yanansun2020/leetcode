package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
public class PersonList {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Yanan", "Sun", 1), new Person("Pa", "Pu", 2), new Person("C", "C", 1));
        sortWithJava7(people);
        sortWithLambda(people);
        //step1 sort by last name

        //step2 print all elements in the list
        //step3 print all people have last name starts with C
    }
    public static void sortWithLambda(List<Person> list) {
        Collections.sort(list, (o1, o2)-> o1.getLastName().compareTo(o2.getLastName()));
        printWithFilterPredicate(list, (p)-> p.getLastName().startsWith("C"));
        printWithFilterPredicate(list, (p)-> true);
    }

    public static void sortWithJava7(List<Person> list) {
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        printWithFilter(list, new Filter(){
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("C");
            }
        });
    }

    public static void printWithFilter(List<Person> list, Filter condition) {
        for (Person p : list) {
            if (condition.test(p)) System.out.println(p);
        }
    }

    public static void printWithFilterPredicate(List<Person> list, Predicate<Person> condition) {
        for (Person p : list) {
            if (condition.test(p)) System.out.println(p);
        }
    }
}

interface Filter {
    boolean test(Person p);
}
