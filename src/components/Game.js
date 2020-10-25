import React, { useState }from "react";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";
import {axios} from "../axios";

export default function Game(props) {
    const [movieTitle, setMovieTitle] = useState("");
    const [movies, setMovies] = useState([]);
    const [started, setStarted] = useState(false);

    const addMovie = (e) => {
        e.preventDefault();
        // console.log("Adding a movie!");
        axios.post("game/movie/add", {gameId: props.gameId, movieTitle: movieTitle})
            .then(response => {
                console.log(response.data);
                let movie = {
                    title: response.data.Title,
                    year: response.data.Year,
                    country: response.data.Country,
                    poster: response.data.Poster
                }
                setMovies(movies.concat(movie));
            })
            .catch(e => console.log(e)
            // TODO: Add error handling (movie not found!)
            )
    };

    const startRound = () => {
        // console.log("Starting the game!");
        axios.post("game/start", {gameId: props.gameId, playerId: props.playerId})
            .then(response => {
                // console.log("game started!");
                console.log(response);
                setStarted(true);
            })
            .catch(e => console.log(e)
            // TODO: Add error handling (prompt to restart the game?)
            )
    };

    const randomMovie = (e) => {
        console.log("Randomly pick a movie from the pool (not implemented yet)")
    }

    return (<div>
        <p>Player Name: {props.playerName}{props.gameOwner && " (Host)"}</p>
        <p>GameId: {props.gameId}</p>
        {(props.gameOwner && !started) && <Button className="mb-2" onClick={startRound} >Start the game!</Button>}
        <br />
        {!started ? <p>Waiting for other players to join...</p> :
            <div>
                <p>The game has started!</p>
                    <br />
                    <Form onSubmit={addMovie}>
                        <Form.Row className="justify-content-center">
                            <Col xs="auto">
                                <Form.Control
                                    className="mb-2"
                                    id="inlineFormInput"
                                    placeholder="Enter Movie Name"
                                    onChange={e => setMovieTitle(e.target.value)}
                                />
                            </Col>
                            <Col xs="auto">
                                <Button type="submit" className="mb-2" variant="light">
                                    Add
                                </Button>
                            </Col>
                        </Form.Row>
                    </Form>
                <p>Movies entered into the pool: {movies.length}</p>
                {props.gameOwner && <Button onClick={randomMovie}>Draw a movie</Button>}
            </div>
            }
        <br />
    </div>);
}