package oa.ms.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//return k random from 0-n
public class KRandom {
    Map<String, String> map = new HashMap<>();

    public static int[] sample(int N, int K) {
        Random random = new Random();
        int result[] = new int[K];

        int select = K;
        while (select > 0) {
            int choose = random.nextInt(N);//随机选一个数
            boolean exist = false;
            for (int i = 0; i < K - select; i++) { //判断这个数是否已经被选择
                if (choose == result[i]) {
                    exist = true;
                    break;
                }
            }
            if (!exist) { // 若没被选择，则加入结果
                result[K - select] = choose;
                --select;
            }
        }

        return result;
    }



    public static int[] sample1(int N, int K) {
        Random random = new Random();
        int numbers[] = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i;
        }

        int result[] = new int[K];

        for (int i = 0; i < K; i++) {
            int choose = random.nextInt(N - i);
            result[i] = numbers[choose];
            numbers[choose] = numbers[N - i - 1];//已抽取数字换到末尾，或者说将没抽取数字提前 //这个正确性也有可能会问
        }

        return result;
    }
}
