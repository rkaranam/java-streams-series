import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FlatMapExample {

    static class MarvelMovie {

        private String name;
        private Date releaseDate;
        private String director;
        private List<String> characters;

        MarvelMovie(String name, Date releaseDate, String director, List<String> characters) {
            this.name = name;
            this.releaseDate = releaseDate;
            this.director = director;
            this.characters = characters;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public List<String> getCharacters() {
            return characters;
        }

        public void setCharacters(List<String> characters) {
            this.characters = characters;
        }

        @Override
        public String toString() {
            return "MarvelMovie {" +
                    "name = '" + name + '\'' +
                    ", releaseDate = " + releaseDate +
                    ", director = '" + director + '\'' +
                    ", characters = " + characters +
                    '}';
        }
    }

    private static Date parseDate(String dateStr) throws ParseException {
        return new SimpleDateFormat("MMM dd, yyyy").parse(dateStr);
    }

    public static void main(String[] args) throws Exception {
        List<MarvelMovie> marvelMovies = Arrays.asList(
                new MarvelMovie("Iron Man", parseDate("May 2, 2008"), "Jon Favreau", Arrays.asList("Iron Man", "War Machine")),
                new MarvelMovie("Avengers", parseDate("May 4, 2012"), "Joss Whedon", Arrays.asList("Iron Man", "Hulk", "Captain America", "Thor", "Black Widow", "Hack Eye", "Nick Fury")),
                new MarvelMovie("Captain America: The Winter Soldier", parseDate("April 4, 2014"), "Anthony and Joe Russo", Arrays.asList("Captain America", "Black Widow", "Winter Soldier", "Falcon", "Nick Fury")),
                new MarvelMovie("Avengers: Age of Ultron", parseDate("May 1, 2015"), "Joss Whedon", Arrays.asList("Iron Man", "Hulk", "Captain America", "Thor", "Black Widow", "Hack Eye", "Nick Fury", "War Machine", "Scarlet Witch", "Vision", "Falcon")),
                new MarvelMovie("Avengers: Infinity War", parseDate("April 27, 2018"), "Anthony and Joe Russo", Arrays.asList("Iron Man", "Hulk", "Captain America", "Thor", "Doctor Strange", "Black Panther", "Black Widow", "Hack Eye", "Nick Fury", "War Machine", "Scarlet Witch", "Vision", "Falcon", "Star Lord", "Gamora", "Groot", "Thanos", "Spider Man")),
                new MarvelMovie("Avengers: Endgame", parseDate("April 26, 2019"), "Anthony and Joe Russo", Arrays.asList("Iron Man", "Hulk", "Captain America", "Thor", "Doctor Strange", "Black Panther", "Black Widow", "Hack Eye", "Nick Fury", "War Machine", "Scarlet Witch", "Vision", "Falcon", "Star Lord", "Gamora", "Groot", "Thanos", "Ant Man", "Spider Man"))
        );

        marvelMovies.forEach(System.out::println);

        System.out.println("Functional Style: ");

        // Identify movies where Ant Man has starred
        Optional<String> antManMovies = marvelMovies.stream()
                .map(marvelMovie -> marvelMovie.getCharacters().stream())
                .flatMap(stringStream -> stringStream.filter(s -> s.equals("Ant Man")))
                .findAny();

        antManMovies.ifPresent(System.out::println);

        List<Integer> myMarks = Arrays.asList(89, 95, null, 48, 63);

        myMarks.forEach(mark -> Optional.ofNullable(mark).ifPresent(System.out::println));

    }
}
