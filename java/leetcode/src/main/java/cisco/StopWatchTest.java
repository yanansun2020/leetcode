package cisco;

import org.apache.commons.lang3.time.StopWatch;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class StopWatchTest {
    public static void main(String[] args) {

        StopWatch stopWatch = StopWatch.createStarted();

        Fibonacci(40);
        stopWatch.stop();

        System.out.println("Get elapsed time in milliseconds: " + stopWatch.getTime(TimeUnit.MILLISECONDS));
        System.out.println("Get elapsed time in seconds: " + stopWatch.getTime(TimeUnit.SECONDS));
        System.out.println("Get elapsed time in minutes: " + stopWatch.getTime(TimeUnit.MINUTES));
        System.out.println("Get elapsed time in hours: " + stopWatch.getTime(TimeUnit.HOURS));

        stopWatch.reset();
        stopWatch.start();
        Fibonacci(40);
        stopWatch.stop();
        System.out.println("Get elapsed time in milliseconds1: " + stopWatch.getTime(TimeUnit.MILLISECONDS));

    }

    private static BigInteger Fibonacci(int n) {
        if (n < 2)
            return BigInteger.ONE;
        else
            return Fibonacci(n - 1).add(Fibonacci(n - 2));
    }
}
