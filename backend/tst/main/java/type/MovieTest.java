package main.java.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    public void setup() {
        movie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
    }

    @Test
    public void getTitle_withBuilder_returnsTitle() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .build();

        // WHEN
        String result = testMovie.getTitle();

        // THEN
        assertEquals("Parasite", result, "Expected to return the correct movie title");
    }

    @Test
    public void getYear_withBuilder_returnsYear() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .build();

        // WHEN
        String result = testMovie.getYear();

        // THEN
        assertEquals("2019", result, "Expected to return the correct movie year");
    }

    @Test
    public void getRated_withBuilder_returnsRated() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .build();

        // WHEN
        String result = testMovie.getRated();

        // THEN
        assertEquals("R", result, "Expected to return the correct movie content rating");
    }

    @Test
    public void getGenre_withBuilder_returnsGenre() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .build();

        // WHEN
        String result = testMovie.getGenre();

        // THEN
        assertEquals("Comedy, Drama, Thriller", result, "Expected to return the correct movie genre");
    }

    @Test
    public void getCountry_withBuilder_returnsCountry() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .build();

        // WHEN
        String result = testMovie.getCountry();

        // THEN
        assertEquals("South Korea", result, "Expected to return the correct movie country");
    }

    @Test
    public void getImdbRating_withBuilder_returnsImdbRating() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        double result = testMovie.getImdbRating();

        // THEN
        assertEquals(8.6, result, "Expected to return the correct movie IMDb rating");
    }

    @Test
    public void equals_withSameObject_returnsTrue() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = testMovie;

        // WHEN + THEN
        assertTrue(testMovie.equals(otherMovie), "Expected same object to return true");
    }

    @Test
    public void equals_withNewObjectWithSameAttributes_returnsTrue() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertTrue(testMovie.equals(otherMovie), "Expected Movies with same values to" +
                " return true");
    }

    @Test
    public void equals_withDifferentTitle_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Old Boy")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different titles to" +
                " return false");
    }

    @Test
    public void equals_withDifferentYear_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2022")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different years to" +
                " return false");
    }

    @Test
    public void equals_withDifferentRated_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("PG-13")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different content ratings to" +
                " return false");
    }

    @Test
    public void equals_withDifferentGenre_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Musical")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different genres to" +
                " return false");
    }

    @Test
    public void equals_withDifferentCountry_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("USA")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different countries to" +
                " return false");
    }

    @Test
    public void equals_withDifferentImdbRating_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(10.0)
                .build();

        // WHEN + THEN
        assertFalse(testMovie.equals(otherMovie), "Expected Movies with different IMDb ratings to" +
                " return false");
    }

    @Test
    public void equals_withNullObject_returnsFalse() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie nullMovie = null;

        // WHEN + THEN
        assertFalse(testMovie.equals(nullMovie), "Movie object should not be equal to null");
    }

    @Test
    public void hashCode_withSameObject_returnsSameHashCode() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = testMovie;

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertEquals(otherMovie.hashCode(), resultHash, "Expected same object to return same hash value");
    }

    @Test
    public void hashCode_withNewObjectWithSameAttributes_returnsSameHashcode() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertEquals(otherMovie.hashCode(), resultHash, "Expected same object to return same hash value");
    }

    @Test
    public void hashCode_withDifferentTitle_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Old Boy")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different titles to return different hash values");
    }

    @Test
    public void hashCode_withDifferentYear_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2022")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different years to return different hash values");
    }

    @Test
    public void hashCode_withDifferentRated_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("PG-13")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different content ratings to return different hash values");
    }

    @Test
    public void hashCode_withDifferentGenre_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Musical")
                .country("South Korea")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different genres to return different hash values");
    }

    @Test
    public void hashCode_withDifferentCountry_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("USA")
                .imdbRating(8.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different countries to return different hash values");
    }

    @Test
    public void hashCode_withDifferentImdbRating_returnsDifferentHash() {
        // GIVEN
        Movie testMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(8.6)
                .build();
        Movie otherMovie = Movie.builder()
                .title("Parasite")
                .year("2019")
                .rated("R")
                .genre("Comedy, Drama, Thriller")
                .country("South Korea")
                .imdbRating(1.6)
                .build();

        // WHEN
        int resultHash = testMovie.hashCode();

        // THEN
        assertNotEquals(otherMovie.hashCode(), resultHash, "Expected Movies with" +
                "different IMDb ratings to return different hash values");
    }
}
