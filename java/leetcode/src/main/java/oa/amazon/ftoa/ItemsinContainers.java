package oa.amazon.ftoa;

import org.junit.Test;

public class ItemsinContainers {
    int[] numberOfItems(String s, int[] startIndices, int[]endIndices){
        int[] ans = new int[startIndices.length];
        for (int i = 0; i < startIndices.length; i++) {
            ans[i] = getNumItems(startIndices[i], endIndices[i], s);
        }
        return ans;
    }

    int[] numberOfItems_1(String s, int[] startIndices, int[]endIndices){
        int[] prefixSum = new int[s.length()];
        init_prefixSum(s, prefixSum);
        int[] ans = new int[s.length()];
        for (int i = 0; i < startIndices.length; i++) {
            int left = findFirstBar(startIndices[i] - 1, s);
            int right = findLastBar(endIndices[i] - 1, s);
            ans[i] = prefixSum[right] - prefixSum[left];
        }
        return ans;
    }
    private void init_prefixSum(String s, int[] prefixSum){
        int firstBar = findFirstBar(0, s);
        int lastBar = findLastBar(s.length() - 1, s);
        int i = 0;
        int numOfStar = 0;
        while (i < s.length()) {
            if (i <= firstBar) {
                prefixSum[i] = numOfStar;
            } else if (i <= lastBar){
                if (s.charAt(i) == '*'){
                    prefixSum[i] = ++numOfStar;
                } else if (s.charAt(i) == '|') {
                    prefixSum[i] = prefixSum[i - 1];
                }
            } else{
                prefixSum[i] = prefixSum[i - 1];
            }
            i++;
        }
    }

    private int findFirstBar(int start, String s){
        int i = start;
        while (s.charAt(i) == '*') {
            i++;
        }
        return i;
    }
    private int findLastBar(int end, String s){
        int j = end;
        while (s.charAt(j) == '*') {
            j--;
        }
        return j;
    }

    int getNumItems(int start, int end, String s){
        int i = start - 1;
        int j = end - 1;
        int count = 0;
        //find the fist position that is '|'
        while (s.charAt(i) == '*') {
            i++;
        }
        //find the last position that is '|'
        while (s.charAt(j) == '*') {
            j--;
        }
        while (i < j) {
            if (s.charAt(i)== '*') {
                count++;
            }
            i++;
        }
        return count;
    }

    @Test
    public void test(){
        int[] start = new int[]{1, 1};
        int[] end = new int[]{5, 6};
        String s = "|**|*|*";
        int[] ans = numberOfItems_1(s, start, end);
    }
}
