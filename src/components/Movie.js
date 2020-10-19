import React, { Component } from "react";
import Button from "react-bootstrap/Button";

class Movie extends Component {
  showRating = (e) => {
    var rating = document.getElementById("imdbRating");
    rating.style.display = "block";
    e.target.style.display = "none";
  };

  render() {
    var movie = this.props.movie;
    return (
      <div>
        <img src={movie.poster} alt={movie.title} height="350vh" />
        <p>
          {movie.rated} | {movie.year} | {movie.country}
        </p>
        <Button onClick={this.showRating} variant="light">
          Click to reveal IMDB Rating
        </Button>
        <p id="imdbRating" style={{ display: "none" }}>
          IMDB Rating: {movie.imdbRating}/10
        </p>
      </div>
    );
  }
}

Movie.defaultProps = {
  title: "The Matrix",
  year: "1999",
  rated: "R",
  genre: "Action/Sci-fi",
  country: "USA",
  imageLink: "http://i.imgur.com/bJw8ndW.png",
  imdbRating: 8.7,
};

export default Movie;
