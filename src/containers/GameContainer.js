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
    e.preventDefault();
    fetch(
      "https://cors-anywhere.herokuapp.com/" + // CORS proxy to avoid browser error
        "http://hollywoodtest3-env.eba-gzbfvjh9.us-west-2.elasticbeanstalk.com/api/v1/movie"
    )
      .then((response) => response.json())
      .then((data) => {
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
      })
      .catch((error) => {
        console.log(error);
      });
  };

  handleChange = (e) => {
    this.setState({
      movieTitle: e.target.value,
    });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    console.log("clicked!");
    fetch(
      "https://cors-anywhere.herokuapp.com/" +
        "http://hollywoodtest3-env.eba-gzbfvjh9.us-west-2.elasticbeanstalk.com/api/v1/movie",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Cache-Control": "no-cache",
          "User-Agent": "PostmanRuntime/7.26.7",
          Accept: "*/*",
          "Accept-Encoding": "gzip, deflate, br",
          Connection: "keep-alive",
        },
        body: JSON.stringify({ movieTitle: this.state.movieTitle }),
      }
    )
      .then((response) => console.log(response))
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    return (
      <div>
        <Button onClick={this.loadMovie} variant="light">
          Pick a random Movie!
        </Button>
        <br /> <br />
        <Form onSubmit={this.handleSubmit}>
          <Form.Row className="justify-content-center">
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
