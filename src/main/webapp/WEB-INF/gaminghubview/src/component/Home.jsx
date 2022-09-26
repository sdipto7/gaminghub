import React, {useEffect} from "react";
import {Button, Container} from 'react-bootstrap';
import {useNavigate} from 'react-router-dom';

export default function Home() {

    const navigate = useNavigate();

    useEffect(() => {
        document.title = "GamingHub | Register or Login";
    }, []);

    const onRegisterClick = () => {
        navigate("/register");
    }

    const onLoginClick = () => {
        navigate("/login");
    }

    return (
        <div className="text-center">

            <h3>Register now or Click on Login if you already have an account</h3>

            <Container>
                <Button
                    className="mx-2"
                    onClick={() => onRegisterClick()}
                    color="primary"
                    outline color="primary">
                    Register
                </Button>

                <Button
                    className="mx-2"
                    onClick={() => onLoginClick()}
                    color="primary"
                    outline color="primary">
                    Login
                </Button>
            </Container>
        </div>
    );
};