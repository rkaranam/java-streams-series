import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "James Gosling",
                "Rod Johnson",
                "Linus Torvalds",
                "Gavin King",
                "Brendan Eich"
        );

        // Java for-each
        for (String founder : names) {
            System.out.println(founder);
        }

        names.forEach(System.out::println);

    }
}
