package streams;

import java.util.ArrayList;
import java.util.List;

public class TestStream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.stream()
                .filter(i -> i % 2 == 0)
                .limit(3)
                .map(i -> i * i)
                .forEach(System.out::println);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);

        List<Integer> c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);

        List<List<Integer>> all = new ArrayList<>();
        all.add(a);
        all.add(b);
        all.add(c);
        all.stream()
                .flatMap(l -> l.stream())
                .forEach(System.out::println);
    }
}
