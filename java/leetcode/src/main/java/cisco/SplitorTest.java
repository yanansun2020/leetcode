package cisco;

public class SplitorTest {
    public static void main(String[] args) {
        String a = "uname#:#2001:420:54ff:a4::127:78";
        String[] res = a.split("#:#");
        String clientIP = res.length > 1 ? res[1] : "127.0.0.1";
        System.out.println(clientIP);
        System.out.println(res[0]);
        System.out.println(res[1]);
        a = "uname:127.0.0.1";
        res = a.split(":", 2);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
