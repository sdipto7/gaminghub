import React, { useEffect } from "react";
import { Button, Container } from 'reactstrap';

export default function Dashboard() {

    useEffect(()=>{
        document.title = "Home";
    }, []);

    return(
        <div className="text-center">
            <h3>Dashboard</h3>
            <p>Contents for Dashboard</p>

            <Container>
                <Button color="primary">Start Using</Button>
            </Container>
        </div>
    );
};