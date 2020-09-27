import React, { Component } from "react";
import Button from "react-bootstrap/Button";

class Movie extends Component {
  showRating = (e) => {
    var rating = document.getElementById("imdbRating");
    rating.style.display = "block";
    e.target.style.display = "none";
  };

  render() {
    return (
      <div>
        <img src={this.props.imageLink} alt={this.props.title} height="350vh" />
        <h3>{this.props.title}</h3>
        <p>
          {this.props.rated} | {this.props.year} | {this.props.country}
        </p>
        <Button onClick={this.showRating} variant="light">
          Click to reveal IMDB Rating
        </Button>
        <p id="imdbRating" style={{ display: "none" }}>
          IMDB Rating: {this.props.imdbRating}/10
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
