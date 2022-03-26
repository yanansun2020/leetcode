package framework;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class StopWatchTest {
    @Test
    public void test() throws InterruptedException {
        StopWatch watch = StopWatch.createStarted();
        for (int i = 0; i < 10; i++) {

        }
        Thread.sleep(1000);
        watch.stop();
        System.out.println(watch.getTime());
        watch.reset();
        watch.start();

        Thread.sleep(2000);
        watch.stop();
        System.out.println(watch.getTime());
    }
}
