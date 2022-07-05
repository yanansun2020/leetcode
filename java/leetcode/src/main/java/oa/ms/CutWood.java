package oa.ms;

import org.junit.Test;

public class CutWood {
    public int cut(int a, int b) {
        //suppose a is the shorter one
        if (a > b) {
            return cut(b, a);
        }
        int edge = 0;
        //case1 cut 2, 2
        int edge1 = Math.min(a/2, b/2);
        edge = Math.max(edge, edge1);
        //case2 cut b to 3 pieces, and a cut to 1
        int edge2 = Math.min(b/3, a);
        edge = Math.max(edge, edge2);
        //case3 cut b to 4 pieces
        edge = Math.max(edge, b/4);
        return edge;
    }
    @Test
    public void test() {
        System.out.println(cut(10, 21));
        System.out.println(cut(13, 11));
        System.out.println(cut(1, 2));
        System.out.println(cut(8, 1));
    }
}
