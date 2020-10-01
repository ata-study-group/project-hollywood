package main.java.type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import javax.inject.Inject;

// TODO: minimize activity, maintaining DAOs for storing/retrieving
public class MovieDao {
    private LinkedList<Movie> movieList = new LinkedList<>();

    @Inject
    public MovieDao() {
    }

    public boolean addMovieByTitle(String movieTitle) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new ParanamerModule());
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(movieTitle)) {
                return false;
            }
        }

        String target = String.format("http://www.omdbapi.com/?apikey=fc1513ba&t=%s",movieTitle);
        URL url = new URL(target);
        Movie movieFromJson = objectMapper.readValue(url, Movie.class);

        movieList.addLast(movieFromJson);
        return true;
    }

    public Movie getNextMovie() {
        return movieList.getLast();
    }
}
