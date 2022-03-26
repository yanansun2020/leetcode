package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class FlipCoin {
    List<String> flipCoin(int n) {
        List<String> res = new ArrayList<>();
        flip(n, res, "");
        return res;
    }
    private void flip(int n , List<String> res, String s) {
        if (n == 0) {
            res.add(s);
            return;
        }
        flip(n - 1, res, s + "H");
        flip(n - 1, res, s + "T");
    }

    public static void main(String[] args) {
        FlipCoin flip = new FlipCoin();
        List<String> res = flip.flipCoin(2);
        System.out.println("1");
    }
}
