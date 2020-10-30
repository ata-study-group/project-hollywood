import React, { useState }from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import { axios } from "../axios.js"
import Game from "./Game.js"
import Header from "./Header.js";

export default function Lobby() {
    const [playerName, setPlayerName] = useState("");
    const [nameSubmitted, setNameSubmitted] = useState(false);
    const [playerId, setPlayerId] = useState("");
    const [gameId, setGameId] = useState("");
    const [gameOwner, setGameOwner] = useState(false);
    const [joinedGame, setJoinedGame] = useState(false);

    const startGame = (e) => {
        e.preventDefault();
        // console.log("starting a game!");
        axios.post("game/create", {playerName: playerName})
            .then(response => {
                // console.log(response.data);
                setPlayerId(response.data.playerId);
                setGameId(response.data.gameId);
                setGameOwner(true);
                setJoinedGame(true);
            });
    }

    const joinGame = (e) => {
        e.preventDefault();
        // console.log("joining a game!");
        if (validateGameId(gameId)) {
            axios.post("game/join", {gameId: gameId, playerName: playerName})
                .then(response => {
                    // console.log(response.data);
                    setPlayerId(response.data.playerId);
                    setGameOwner(response.data.gameOwner);
                    setJoinedGame(true);
                })
                .catch(e =>
                    console.log(e)
                    // TODO: add error handling
                );
        } else {
            console.log("gameId is not valid.");
            // TODO: add react-flash-message for invalid ID
        }
    }

    // Validates if gameId is UUID.
    const validateGameId = (gameId) => {
        let pattern = new RegExp(/^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i);
        return gameId !== "" && pattern.test(gameId);
    }

    return <div>
        {!nameSubmitted && <Header /> }
        {!nameSubmitted &&
            <Form onSubmit={(e)=>{
                e.preventDefault();
                setNameSubmitted(true);}}>
                <Form.Row className="justify-content-center">
                    <Col xs="auto">
                        <Form.Control
                            className="mb-2"
                            id="inlineFormInput"
                            placeholder="Enter your name"
                            onChange={e => setPlayerName(e.target.value)}
                        />
                    </Col>
                    <Col xs="auto">
                        <Button type="submit" className="mb-2" variant="light">
                            Enter
                        </Button>
                    </Col>
                </Form.Row>
            </Form>}
        {(nameSubmitted && !joinedGame) &&
            <div>
                <p>Welcome, {playerName}!</p>
                <Button onClick={startGame} variant="light">Start a new game</Button>
                <br /> <br />
                <Form onSubmit={joinGame}>
                    <Form.Row className="justify-content-center">
                        <Col xs="auto">
                            <Form.Control
                                className="mb-2"
                                id="inlineFormInput"
                                placeholder="Enter Game ID"
                                onChange={e => setGameId(e.target.value)}
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit" className="mb-2" variant="light">
                                Join
                            </Button>
                        </Col>
                    </Form.Row>
                </Form>
            </div>}
        {joinedGame && <Game gameId={gameId} playerId={playerId} playerName={playerName} gameOwner={gameOwner} />}
    </div>
}
