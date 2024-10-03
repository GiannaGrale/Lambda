package consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("vinoth");
        list.add("selva");

        Consumer<String> dbConsumer = (s) ->  {
            System.out.println("I am writing into DB :: " + s);
        };

        Consumer<String> loggingConsumer = (s) ->  {
            System.out.println("I am writing into log file :: " + s);
        };

        //can be chained only of the same type
        Consumer<String> dbLogConsumer =  dbConsumer.andThen(loggingConsumer);

        Map<String, Consumer<String>> map = new HashMap<>();
        map.put("db", dbConsumer);
        map.put("log", loggingConsumer);
        map.put("dblog", dbLogConsumer);

        System.setProperty("consumer-type", "db");

        list.forEach(map.get(System.getProperty("consumer-type")));
        BiConsumer<String, Integer> biConsumer = (s, k) ->
        {
            System.out.println("The name is :: " + s);
            System.out.println("The age is :: " + k);
        };

        biConsumer.accept("udemy", 15);

    }
}
