package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * match the heaviest person with the lightest person
 */
public class BoatstoSavePeople {
    public int numRescueBoats(Integer[] people, int limit) {
        Arrays.sort(people, (a, b)->b-a);
        int i = 0;
        int j = people.length - 1;
        int boat = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boat++;
        }
        if (i == j) {
            boat++;
        }
        return boat;
    }
}
