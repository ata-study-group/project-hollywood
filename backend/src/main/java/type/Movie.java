package type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @JsonProperty("Title") public String title;
    @JsonProperty("Year") public String year;
    @JsonProperty("Rated") public String rated;
    @JsonProperty("Genre") public String genre;
    @JsonProperty("Country") public String country;
    @JsonProperty("Type") public String type;

    @JsonProperty("Poster") public String imageLink;
    public Double imdbRating;
}
