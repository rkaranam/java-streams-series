import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFileReader {
    public static void main(String[] args) throws IOException {

        // Print String inside <artifactId></artifactId> tags in pom.xml
        List<String> result = Files.lines(Paths.get("/home/rajasekhar/IdeaProjects/java-streams/pom.xml"))
                .filter(line -> line.contains("artifactId"))
                .map(line -> line.trim()
                        .replaceAll("artifactId", "")
                        .replaceAll("<", "")
                        .replaceAll("/", "")
                        .replaceAll(">", ""))
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
