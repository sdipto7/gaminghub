import React, {useEffect, useState} from "react";
import {Button, Container} from 'reactstrap';
import { useNavigate } from "react-router-dom";
import LoginForm from "./user/LoginForm";

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
                    outline color="warning">
                    Register
                </Button>

                <Button
                    className="mx-2"
                    onClick={() => onLoginClick()}
                    color="primary"
                    outline color="warning">
                    Login
                </Button>
            </Container>
        </div>
    );
};