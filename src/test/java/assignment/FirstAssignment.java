package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FirstAssignment {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/first-names.txt");
        List<String> list = Files.readAllLines(path);

        long count = list
                .stream()
                .filter(l -> l.startsWith("B"))
                .count();
        System.out.println(count);

        List<String> newList = list
                .stream()
                .filter(l -> l.startsWith("C"))
                .filter(s -> s.contains("s"))
                .collect(Collectors.toList());

        System.out.println(newList.size());

        int charLength = list
                .stream()
                .filter(l -> l.startsWith("M"))
                .map(String::trim)
                .collect(Collectors.joining())
                .length();

        System.out.println(charLength);
    }
}
