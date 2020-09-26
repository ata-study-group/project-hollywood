import org.junit.jupiter.api.Test;
import type.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void givenAnnotatedTitle_thenHasGettersAndSetters() {
        Movie movie = Movie.builder()
                        .title("someTitle")
                        .build();
        System.out.println(movie);
        assertEquals("someTitle",movie.getTitle());
    }
}