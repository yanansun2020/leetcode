package java8;

public class TypeInference {
    public static void main(String[] args) {
        //the real implementation is here as a parameter
        printLength((String s)-> s.length());
    }

    public static void printLength(StringLengthLambda l) {
        System.out.println(l.getLength("This is a test"));
    }

    interface StringLengthLambda{
        int getLength(String s);
    }
}
