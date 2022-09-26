import React from "react";
import {Link} from "react-router-dom";
import {ListGroup} from "react-bootstrap";

export default function Menu() {
    return (
        <ListGroup>
            <Link className="list-group-item list-group-item-action" tag={"a"} to='/dashboard' action>Dashboard</Link>
            <Link className="list-group-item list-group-item-action" tag={"a"} to='/dashboard' action>Dashboard</Link>
        </ListGroup>
    );
};