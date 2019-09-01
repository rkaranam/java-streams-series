import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> founders = Arrays.asList(
                "James Gosling",
                "Rod Johnson",
                "Linus Torvalds",
                "Gavin King",
                "Brendan Eich"
        );

        System.out.println("**** Imperative Style: ****");

        for (String founder : founders) {
            if (isNotLinus(founder)) {
                System.out.println(founder);
            }
        }

        System.out.println("**** Functional Style: ****");

        founders.stream()
                .filter(FilterExample::isNotLinus) // filter uses Predicate interface
                .forEach(System.out::println); // forEach uses Consumer interface

    }

    private static boolean isNotLinus(String name) {
        return !name.equals("Linus Torvalds");
    }
}
