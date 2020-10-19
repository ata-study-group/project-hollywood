import React, { Component } from "react";
import Movie from "../components/Movie.js";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";

class GameContainer extends Component {
  state = {
    showMovie: false,
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
    movieTitle: "",
  };

  loadMovie = (e) => {
    fetch(
      "https://cors-anywhere.herokuapp.com/" + // CORS proxy to avoid browser error
        "http://hollywoodtest3-env.eba-gzbfvjh9.us-west-2.elasticbeanstalk.com/api/v1/movie"
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        this.setState({
          showMovie: true,
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
  };

  handleChange = (e) => {
    this.setState({
      movieTitle: e.target.value,
    });
    console.log(this.state.movieTitle);
  };

  handleSubmit = (e) => {
    e.preventDefault();
    fetch(
      "http://hollywoodtest3-env.eba-gzbfvjh9.us-west-2.elasticbeanstalk.com/api/v1/movie",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: { movieTitle: this.state.movieTitle },
      }
    );
  };

  render() {
    return (
      <div>
        <Button onClick={this.loadMovie} variant="light">
          Pick a random Movie!
        </Button>
        <br /> <br />
        <Form>
          <Form.Row
            className="justify-content-center"
            onSubmit={this.handleSubmit}
          >
            <Col xs="auto">
              <Form.Control
                className="mb-2"
                id="inlineFormInput"
                placeholder="Movie Title"
                onChange={this.handleChange}
              />
            </Col>
            <Col xs="auto">
              <Button type="submit" className="mb-2" variant="light">
                Search
              </Button>
            </Col>
          </Form.Row>
        </Form>
        <br />
        {this.state.showMovie ? <Movie movie={this.state.movie} /> : null}
      </div>
    );
  }
}

export default GameContainer;
