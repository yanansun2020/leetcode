package cisco;

public class StringTest {
    public static void main(String[] args) {
        String s = "pattern";
        for(int i = 0; i <= s.length(); i++) {
            String p = s.substring(i, s.length());
            System.out.println(p);
        }
        System.out.println("====");
    }
}
