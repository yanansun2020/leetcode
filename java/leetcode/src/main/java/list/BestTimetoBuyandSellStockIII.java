package list;

public class BestTimetoBuyandSellStockIII {
//    i :transaction j : jth day
//    profit[i][j] = max{ profit[i][j-1], prices[j]-prices[m] + profit[i-1][m]} 0<=m<i
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];
        int max_profit = 0;
        for (int i =0; i< 2; i++){
            int[] tmp_profit = new int[prices.length];
            int min_price_before = prices[0]-profit[0];
            for (int j =1; j< prices.length; j++){
                tmp_profit[j] = Math.max(tmp_profit[j-1], prices[j] - min_price_before);
                max_profit = Math.max(max_profit, tmp_profit[j]);
                min_price_before = Math.min(min_price_before, prices[j] - profit[j]);
            }
            profit = tmp_profit;
        }
        return max_profit;
    }

    public int maxProfit(int k, int[] prices) {
        int length = Math.min(k, prices.length / 2) + 1; // caculate the theoretically max transactions we can make
        int sell[] = new int[length];
        int hold[] = new int[length];
        for(int i = 0; i < length; i++)
            hold[i] = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            for(int j = length - 1; j >= 1; j--) { // index from high to low since hold[k] depends on sell[k - 1]
                sell[j] = Math.max(sell[j], hold[j] + prices[i]);
                hold[j] = Math.max(hold[j], sell[j - 1] - prices[i]);
            }
        }
        return sell[length - 1];
    }

    public static void main(String[] args) {
        int[] array = {3,3,5,0,0,3,1,4};
        BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
        System.out.println(test.maxProfit(array));
        int[] array1 = {1,2,3,4,5};
        System.out.println(test.maxProfit(array1));
    }
}
