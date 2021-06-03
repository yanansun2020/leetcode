package java8;

public class ThisKeyword {
    public static void main(String[] args) {
        ThisKeyword thisK = new ThisKeyword();


        thisK.doProcess(10, (i) -> {
            System.out.println(i);
            //System.out.println(this); will not work here
        });

        thisK.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println(i);
                System.out.println(this);
            }

            public String toString() {
                return "Haha";
            }
        });
    }
    public void doProcess(int i, Process p) {
        p.process(i);
    }     
}
