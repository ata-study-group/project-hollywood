import React, { Component } from "react";
import Movie from "../components/Movie.js";

class GameContainer extends Component {
  state = {
    movie: {
      country: null,
      genre: null,
      poster: null,
      rated: null,
      title: null,
      type: null,
      year: null,
      imdbRating: 0.0,
    },
  };

  componentDidMount() {
    fetch(
      "https://cors-anywhere.herokuapp.com/" + // CORS proxy to avoid browser error
        "http://hollywoodtest3-env.eba-gzbfvjh9.us-west-2.elasticbeanstalk.com/api/v1/movie"
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        this.setState({
          movie: {
            country: data.Country,
            genre: data.Genre,
            poster: data.Poster,
            rated: data.Rated,
            title: data.Title,
            type: data.Type,
            year: data.Year,
            imdbRating: data.imdbRating,
          },
        });
      });
  }

  render() {
    return (
      <div>
        <Movie movie={this.state.movie} />
      </div>
    );
  }
}

export default GameContainer;
