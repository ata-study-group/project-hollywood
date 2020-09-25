import React, { Component } from "react";
import Movie from "../components/Movie.js";

class GameContainer extends Component {
  render() {
    return (
      <div>
        <Movie
          title="The Matrix"
          imageLink="https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,665,1000_AL_.jpg"
        />
      </div>
    );
  }
}

export default GameContainer;
