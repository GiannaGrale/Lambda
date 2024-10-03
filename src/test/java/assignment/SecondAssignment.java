package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondAssignment {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/first-names.txt");
        List<String> list = Files.readAllLines(path);

        List<String> test = list
                .stream()
                .filter(name -> name.contains("-"))
                .map(name -> name.replace("-", " "))
                .collect(Collectors.toList());

        System.out.println(test);

        Optional<String> op = test.stream()
                .map(name -> name.split(" "))
                .flatMap(Arrays::stream)
                .max(Comparator.comparing(String::length));

        System.out.println(op.get());

    }
}
