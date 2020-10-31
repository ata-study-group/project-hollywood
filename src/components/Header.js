import React from "react";
import { Image } from "react-bootstrap"

function Header() {

    const style = { width: "400px" };

    return (
        <div className="container">
            <br/>
            <div className="row">
                <div className="col align-self-center">
                    <Image
                        src={require('../logo.png')}
                        alt="Logo"
                        style={ style }
                    />
                </div>
            </div>
            <br/>
            <div className="row">
                <div className="col align-self-center">
                    <h3>Enter your name to play</h3>
                    <br/>
                </div>
            </div>
        </div>
    );
}

export default Header;
