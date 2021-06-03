package java8;

public class RunnableExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("hello");
            }
        });
        myThread.run();

        Thread lambdaThread = new Thread(()->System.out.println("hello1"));
        lambdaThread.run();
    }
}
