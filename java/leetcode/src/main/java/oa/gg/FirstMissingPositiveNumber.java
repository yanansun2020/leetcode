package oa.gg;

import java.util.HashMap;
import java.util.Map;

/**
 * 有两个func, 一个put, 放进去一个数，一个get,拿出已经put进去的数里面missing的最小的数。
 * 比如put 1,2,3,6,8,7
 * 那么get就应该返回4‍‌‍‌‌‌‌‌‌‌‍‌‌‌‍‌‍‍‌‌
 * 再put4
 * get就返回5
 *
 * 楼主没想到O(1)的解，大家有什么好的方法吗
 */
public class FirstMissingPositiveNumber {
    int firstMissingPositive;
    Map<Integer, Integer> map;
    public FirstMissingPositiveNumber(){
        firstMissingPositive = 1;
        map = new HashMap<>();
    }
    void put(int number) {
        map.put(number, 1);
        while(map.containsKey(firstMissingPositive)) {
            firstMissingPositive++;
        }
    }
    int get() {
        return firstMissingPositive;
    }
}
