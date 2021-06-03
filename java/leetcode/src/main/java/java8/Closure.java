package java8;

public class Closure {
    public static void main(String[] args) {
        int a = 10;
        //b is effecctively as a final variable
        int b = 5;
        doProcess(a, (i) -> System.out.println(i + b));
    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}