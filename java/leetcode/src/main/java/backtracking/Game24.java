package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game24 {
    public boolean judgePoint24(int[] cards) {
        LinkedList<Double> cardList = new LinkedList<>();
        for(int i = 0; i < cards.length; i++) {
            cardList.add(new Double(cards[i]));
        }
        return helper(cardList);
    }

    private boolean helper(LinkedList<Double> cards) {
        if (cards.size() == 1) {
            if(Math.abs(cards.get(0)-24.0)<0.001) return true;
            return false;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                LinkedList<Double> tmp = getValues(cards.get(i), cards.get(i));
                for (Double d : tmp) {
                    LinkedList<Double> next=new LinkedList<>();
                    next.add(d);
                    for(int k=0;k<cards.size();k++){
                        if(k!=i && k!=j) next.add(cards.get(k));
                    }
                    if(helper(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private LinkedList<Double> getValues(double a, double b) {
        LinkedList<Double> res = new LinkedList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }

    public static void main(String[] args) {
        int[] cards = new int[]{4,1,8,7};
        Game24 game24 = new Game24();
        boolean res = game24.judgePoint24(cards);
        System.out.println(res);
    }
}
