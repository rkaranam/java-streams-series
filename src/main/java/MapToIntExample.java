import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToIntExample {

    static class Person {

        private String name;
        private Integer age;

        Person(String name) {
            this.name = name;
            this.age = 60;
        }

        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
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
            return "Person {" +
                    "name = '" + name + '\'' +
                    ", age = " + age +
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
                .filter(MapToIntExample::isNotLinus)    // filter uses Predicate interface
                .map(Person::new)                       // map uses Function interface
                .forEach(System.out::println);          // forEach uses Consumer interface
        // forEach is a terminal operation means stream ends here

        List<Person> usersList = founders.stream()
                .filter(MapToIntExample::isNotLinus)    // filter uses Predicate interface
                .map(Person::new)                       // map uses Function interface
                .collect(Collectors.toList());          // collect is also a terminal operation

        System.out.println("**** Using Stream mapToInt(): ****");

        int agesSum = usersList.stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println("Sum of their ages: " + agesSum);

        System.out.println("**** Using Stream map and filter: ****");

        Map<String, Integer> marvelHeroes = new HashMap<>();
        marvelHeroes.put("Iron Man", 45);
        marvelHeroes.put("Captain America", 100);
        marvelHeroes.put("Thor", Integer.MAX_VALUE);
        marvelHeroes.put("Thanos", Integer.MAX_VALUE);
        marvelHeroes.put("Groot", 4);
        marvelHeroes.put("Hulk", 49);
        marvelHeroes.put("Scarlet Witch", 29);
        marvelHeroes.put("Black Widow", 34);
        marvelHeroes.put("Ant Man", 49);

        long agelessHeroes = marvelHeroes.keySet().stream()
                .map(name -> new Person(name, marvelHeroes.get(name)))
                .filter(MapToIntExample::isImmortal)
                .count();

        System.out.println("Count of Immortal Marvel Heroes: " + agelessHeroes);

        List<Person> immortals = marvelHeroes.keySet().stream()
                .map(name -> new Person(name, marvelHeroes.get(name)))
                .filter(MapToIntExample::isImmortal)
                .collect(Collectors.toList());

        immortals.forEach(System.out::println);

    }

    private static boolean isImmortal(Person person) {
        return person.getAge() >= 100;
    }

    private static boolean isNotLinus(String name) {
        return !name.equals("Linus Torvalds");
    }
}
