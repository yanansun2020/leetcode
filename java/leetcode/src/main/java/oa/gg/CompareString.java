package oa.gg;

import org.junit.Test;

public class CompareString {
    public int compare(String[] arr, String target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            String m_s = arr[mid];
            if (m_s.compareTo(target) == 0) {
                return mid;
            }
            if (m_s.compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String[] arr = { "for", "", "", "", "geeks", "ide", "", "practice", "","", "quiz", "", "" };
        int res = compare(arr, "quiz");
    }
}
