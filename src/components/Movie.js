import React, { Component } from "react";

class Movie extends Component {
  render() {
    var movie = this.props.movie;
    return (
      <div>
        <img src={movie.poster} alt={movie.title} height="350vh" />
        <p>
          {movie.rated} | {movie.year} | {movie.country}
        </p>
        <p id="imdbRating">IMDB Rating: {movie.imdbRating}/10</p>
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
