package hackerrank;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        long numOfA = numOfAs(0, s.length(), s);
        long k = n/s.length();
        long mod = n % s.length();
        long remain = numOfAs(0, mod, s);
        return k * numOfA + remain;
    }
    private static long numOfAs(int start, long end, String s){
        int remain = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == 'a') {
                remain++;
            }
        }
        return remain;
    }

}
