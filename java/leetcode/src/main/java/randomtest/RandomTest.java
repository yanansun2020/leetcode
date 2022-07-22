package randomtest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomTest {
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    @Test
    public void test() {
//        for (int i = 0; i < 10; i++) {
//            int t = getRandomNumberUsingNextInt(0, 3);
//            System.out.println(t);
//        }

        char c = 'c';
        if (Character.isLetter(c) && Character.isLowerCase(c)) {
            System.out.println("yes");
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

    }


}
