import React from "react";
import Navbar from "react-bootstrap/Navbar";

function NavBar() {

    return (
        <Navbar className="nav-bar" variant="dark" bg="dark">
            <Navbar.Brand className="nav-bar-brand" href="#">
                Project Hollywood v0.5
            </Navbar.Brand>
            <Navbar.Text className="nav-bar-text"> Signed in as:[Player Name] </Navbar.Text>
        </Navbar>
    );
}

export default NavBar;