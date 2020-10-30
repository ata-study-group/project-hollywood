import React from "react";
import "./App.css";
import Lobby from "./components/Lobby.js";
import NavBar from "./components/NavBar.js";

export default function App() {
  return (
    <div className="App">
      <header className="App-header"></header>
      <NavBar/>
      <Lobby/>
    </div>
  );
}
