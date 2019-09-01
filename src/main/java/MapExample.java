import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapExample {

    static class Person {

        private String name;
        private Integer age;

        public Person(String name) {
            this.name = name;
            this.age = 60;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

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
                Person founderObject = new Person(founder);
                System.out.println(founderObject);
            }
        }

        System.out.println("**** Functional Style: ****");

        founders.stream()
                .filter(MapExample::isNotLinus) // filter uses Predicate interface
                .map(new Function<String, Person>() {
                    @Override
                    public Person apply(String str) {
                        return new Person(str);
                    }
                })
                .forEach(System.out::println); // forEach uses Consumer interface

    }

    private static boolean isNotLinus(String name) {
        return !name.equals("Linus Torvalds");
    }
}
