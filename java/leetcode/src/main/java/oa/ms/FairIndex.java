package oa.ms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FairIndex {
    public int CountIndexes(List<Integer> A, List<Integer> B) {
        List<Integer> a = new ArrayList<>();

        Set<String> set = new HashSet<String>();
        int length = A.size();
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < length; i++) {
            sumA += A.get(i);
            sumB += B.get(i);
        }
        if (sumA != sumB) {
            return 0;
        }
        long preA = 0, preB = 0;
        int answer = 0;
        for (int i = 0; i < length - 1; i++) {
            preA += A.get(i);
            preB += B.get(i);
            if (preA == preB && sumA - preA == preA) {
                answer += 1;
            }
        }

        return answer;
    }
    @Test
    public void test() {
        String s = "X-Y";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb.toString());
        System.out.println(s);
    }
}
