package function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer, Integer> plus2 = (i) -> i + 2;
        Function<Integer, Integer> square = (i) -> i * i;

        System.out.println(
                plus2.andThen(square).apply(8));
    }
}
