package quiz;

public class Test {
    static int count = 0;
    public static void main(String[] args){
        String msg = "hello";
        print(msg);
        msg += "world";
        print(msg);

//        String s = "noti";
//        boolean k = s instanceof String;
//        String m = s.getClass().getSimpleName();
//        Boolean p = Boolean.valueOf("False");
//
//        if (count < 3) {
//            count++;
//            main(null);
//        } else {
//            return;
//        }
    }
    static void print(String msfd){
        System.out.print(msfd);
        msfd += " ";
    }
}
