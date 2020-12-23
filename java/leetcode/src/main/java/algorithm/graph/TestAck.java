package algorithm.graph;

import org.junit.Test;

public class TestAck {
    int ack(int n, int m) {
        System.out.println("n=" + n + " m=" + m);
        if (n == 0) {
            return m;
        }
        if (m == 0){
            int k = ack(n - 1, 1);
            return k;
        }
        int t = ack(n, m - 1);
        int s = ack(n - 1, t);
        return s;
    }

    @Test
    public void test(){
        ack(1, 2);
    }
}
