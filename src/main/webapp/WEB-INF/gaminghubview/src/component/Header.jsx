import React from "react";
import {Card} from "react-bootstrap";

export default function Header() {
    return (
        // This will manually center and width half
        // <div className="m-auto align-self-center" style={{ width: '50%', boxShadow: '3px 6px 3px #ccc' }}>
        <div>
            <Card className="my-4 text-light bg-dark text-center">
                <Card.Body>
                    <h1 className="text-center my-4">WELCOME TO GAMING HUB</h1>
                    <h6 className="text-center my-4">ONE PLACE TO PLAY IT ALL</h6>
                </Card.Body>
            </Card>
        </div>
    );
};