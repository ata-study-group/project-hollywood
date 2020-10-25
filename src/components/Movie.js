import React from "react";

const Movie = (props) => {
  return <div>
      <img src={props.movie.poster} alt={props.movie.title} height="350vh" />
      <p>
          {props.movie.year} | {props.movie.country}
      </p>
  </div>
}

export default Movie;