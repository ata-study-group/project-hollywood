import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;
import type.Movie;

import java.io.File;
import java.net.URL;

public class App {

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new ParanamerModule());

        //serializing object to json
        Movie movie = Movie.builder()
                        .title("TestTitle")
                        .imdbRating(Double.valueOf("8.8"))
                        .build();

        String jsonString = objectMapper.writeValueAsString(movie);
        System.out.println("Serialized json string: " + jsonString);

        //desirialize json string into java object
        String jsonInput = "{\"title\":\"SomeMovie\",\"year\":\"2022\",\"rated\":\"R\", \"notrated\":\"R\"}";
        Movie movieFromJsonString = objectMapper.readValue(jsonInput, Movie.class);
        System.out.println("From jsonString: " + movieFromJsonString);


        //desirialize json url into java object
        URL url = new URL("http://www.omdbapi.com/?apikey=fc1513ba&t=Superbad");
        Movie movieFromJson = objectMapper.readValue(url, Movie.class);
        System.out.println("From http: " + movieFromJson);


        //desirialize file into java object
        String path = "/Users/myronenk/Documents/CS/IdeaProjects/project-hollywood/src/backend/src/main/resources/testMovie.json";
        Movie movieFromFile = objectMapper.readValue(new File(path), Movie.class);
        System.out.println("From file: " +movieFromFile);
    }
}
