import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekAndSkipExample {
    public static void main(String[] args) {
        List<String> starks = Stream.of("Ned Stark", "Arya Stark", "Sansa Stark", "Rob Stark", "Bran Stark", "Jamie Lannister")
                .peek(obj -> System.out.print(obj + "\t"))      // prints values in stream at this point
                .filter(obj -> !obj.contains("Lannister"))
                .collect(Collectors.toList());

        System.out.println("House Stark: " + starks);

        IntStream.of(23, 45, 632, -235, 86, -1293)
                .skip(2)                                        // skips first 2 values in the stream
                .filter(x -> x > 0)
                .forEach(System.out::println);
    }
}
