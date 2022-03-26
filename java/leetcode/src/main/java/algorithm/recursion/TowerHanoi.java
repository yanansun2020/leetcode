package algorithm.recursion;

import org.junit.Test;

public class TowerHanoi {
    static int m =0;
    public void move(int disks,String s,String d) {
        System.out.println("#" + (++m) +" move: " +"  move "+ disks+" from " + s +" to " + d);
    }
    public void hanoi(int n,String src,String dest,String tmp) {
        if(n == 1)
            move(1, src, dest);
        else {
            hanoi(n - 1, src, tmp, dest);
            move(n, src, dest);
            hanoi(n - 1, tmp, dest, src);
        }
    }

    @Test
    public void test() {
        hanoi(3, "src", "dest", "tmp");
    }
}
