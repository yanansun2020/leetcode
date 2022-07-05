package oa.ms;

import java.util.ArrayList;
import java.util.Collections;

public class WidestTree {
    public static Integer solution2(int[] X1, int[] Y1) {

        int maxX = 0;
        int maxY = 0;
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();

        for (int i : X1) {
            X.add(i);
        }

        for (int i : Y1) {
            Y.add(i);
        }

        Collections.sort(X);
        Collections.sort(Y);

        for (int i = 1; i < X.size(); i++) {
            int j = X.get(i) - X.get(i - 1);
            maxX = j >= maxX ? j : maxX;
        }

        for (int i = 1; i < Y.size(); i++) {
            int j = Y.get(i) - Y.get(i - 1);
            maxY = j >= maxY ? j : maxY;
        }

        return maxX >= maxY ? maxX : maxY;
    }
}
