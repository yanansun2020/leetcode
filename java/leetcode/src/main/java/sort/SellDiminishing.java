package sort;

import java.util.Arrays;
import java.util.Collections;

public class SellDiminishing {
    public int maxProfit(int[] inventory, int orders) {
        int MOD = 1000000007;
        long res = 0;
        int cur = inventory[0];
        int n = inventory.length;
        inventory = Arrays.stream(inventory).boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        int index = 0;

        while (orders > 0) {
            while(index < n && inventory[index] == cur) {
                index++;
            }
            int endValue = inventory[index];
            int take = cur - endValue;
            int count = Math.min(orders, take * index);
            int r = 0;
            if (orders < take * index) {
                take = orders/index;
                r = orders%index;
            }
            long nextValue = cur - take;
            res =(res + (cur + nextValue + 1) * take/2 * index + nextValue * r)%MOD;
            orders -= count;
            cur = endValue;
        }
        return (int)res;
    }
}
