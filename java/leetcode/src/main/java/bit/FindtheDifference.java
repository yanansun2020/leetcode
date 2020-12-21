package bit;

import org.junit.Test;

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        String c = s + t;
        int ans = 0;
        for (int i =0; i< c.length(); i++) {
            ans = (c.charAt(i)) ^ ans;
        }
        return (char)(ans);
    }

    @Test
    public void test(){
        char ans = findTheDifference("abc", "abce");
    }
}
