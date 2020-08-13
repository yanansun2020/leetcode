package oa.robinhood;

public class ReverseInteger {
    public int reverse(Integer n){
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while(i + 1 < sb.length()){
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i+1));
            sb.setCharAt(i+1, tmp);
            i+= 2;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(123));
        System.out.println(test.reverse(123456));
    }
}
