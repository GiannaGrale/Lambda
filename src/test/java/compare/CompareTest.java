package compare;

import com.udemy.compare.Student;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class CompareTest {

    public static void main(String[] args) {
        Student a = new Student("Adam", 90, 187);
        Student b = new Student("Bob", 87, 185);
        Student c = new Student("Chris", 76, 171);

        Optional<Student> op = Stream.of(a, b, c)
                .min(Comparator.comparing(Student::getHeight));
        System.out.println(op.get());
    }
}
