package java8;

import java.util.function.BiConsumer;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
        int key = 2;
        process(numbers, key, wrapperLambda((x, y) -> System.out.println(x / y)));
    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : numbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (x, y) -> {
            try{
                consumer.accept(x, y);
            } catch(ArithmeticException e) {
                System.out.println("Error!");
            }
        };
    }
}
