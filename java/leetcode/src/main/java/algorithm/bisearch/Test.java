package algorithm.bisearch;

public class Test {
    @org.junit.Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j >= 2) {
                    break;
                }
            }
            System.out.println(i);
        }
    }
}
