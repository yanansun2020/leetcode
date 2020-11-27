package slidingwindow;

import org.junit.Test;

/**
 * think about n - k
 */
public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int window_length = cardPoints.length - k;
        int min_not_select = init_window_value(cardPoints, window_length);
        int prev_value = min_not_select;
        for (int i = 1; i <= cardPoints.length - window_length; i++){
            int new_window_value = prev_value - cardPoints[i-1] + cardPoints[i + window_length - 1];
            min_not_select = Math.min(new_window_value, min_not_select);
            prev_value = new_window_value;
        }
        return  count_all(cardPoints) - min_not_select;
    }

    private int init_window_value(int[] cardPoints, int size){
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += cardPoints[i];
        }
        return count;
    }

    private int count_all(int[] cardPoints){
        int count = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            count += cardPoints[i];
        }
        return count;
    }
    @Test
    public void test(){
        int[] cards = new  int[]{1,2,3,4,5,6,1};
        int res = maxScore(cards, 3);
        cards = new  int[]{2,2,2};
        res = maxScore(cards, 2);
        cards = new  int[]{9,7,7,9,7,7,9};
        res = maxScore(cards, 7);
        cards = new  int[]{1,1000,1};
        res = maxScore(cards, 1);
        cards = new  int[]{1,79,80,1,1,1,200,1};
        res = maxScore(cards, 3);
    }
}
