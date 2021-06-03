package java8;

public class FirstFunction {
    // myFunction = ()-> {System.out.println("Hello World");};
    // myFunction1 = (int a)-> a * 2;
    // addFunction = (int a, int b) -> a + b;
    // divideFunction = (int a, int b) -> {
    //     if (b == 0) {
    //         return 0;
    //     }
    //     return a/b;
    // };
    // stringLengthCountFunction = (String s)->s.length();

    public void greet(Greeting greet) {
        greet.perform();
    }
    public static void main(String[] args) {
        Greeting lambdaGreeting = ()-> {System.out.println("Hello World");};
        lambdaGreeting.perform();
        Greeting helloGreeting = new HelloGrreeting();
        helloGreeting.perform();
        Greeting inlineGreeting = new Greeting(){

            @Override
            public void perform() {
                System.out.println("Hello World");
            }
            
        };
        inlineGreeting.perform();
        FirstFunction function = new FirstFunction();
        function.greet(()-> System.out.println("Hello World"));

        Add addFunction = (int a, int b)-> a + b;
        int p = addFunction.add(1, 2);
    }
}
//if use a interface to create a lambda, the interface can have only one method
// interface Greeting{
//     void perform();
//     // int add(int a, int b);
// }

class HelloGrreeting implements Greeting{

    @Override
    public void perform() {
        System.out.println("Hello World");
    }

    // @Override
    // public void behave() {
    //     // TODO Auto-generated method stub
        
    // }
    
}

interface Add{
    int add(int x, int y);
}