package oa.ms;

public class InsertWithConsecutiveThreeA {
    //Thus in order to solve this task we need to count all non A chars. When we will know this number it
    // will be easy to calculate how many As we can add. This number will be
    // 2 * (number of possible places to insert + 1) – number of found As In other words 2 * (N + 1) – (N – number of As)

    int solution(String s) {
        int count_As = 0, count_others = 0, s_len = s.length();
        for (int i = 0; i < s_len; ++i) {
            if (s.charAt(i) == 'a') {
                count_As++;
            }
            else {
                count_others++;
                count_As = 0;
            }
            if (count_As == 3) {
                return -1;
            }
        }
        return 2 * (count_others + 1) - (s_len - count_others);
    }

}
