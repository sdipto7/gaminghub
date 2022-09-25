import React, {Fragment, useEffect, useState} from "react";
import {Container, Form, FormGroup, Input, Label, Button} from "reactstrap";

import {findUserForLogin} from "../../api/UserApi";
import {findUserUrl} from "../../resource/Url";
import {apiValidationForLogin, frontendValidationForLogin} from "../../validator/UserValidator";

export default function LoginForm() {
    const [user, setUser] = useState({});
    const [formValidation, setFormValidation] = useState({});

    useEffect(() => {
        document.title = "GamingHub | Login";
    }, []);

    const onChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    };


    const handleSubmit = async (event) => {
        event.preventDefault();

        setFormValidation(frontendValidationForLogin(user));

        if (Object.keys(formValidation).length === 0) {
            let response = await findUserForLogin(findUserUrl, user);

            response.hasError ?
                setFormValidation(apiValidationForLogin(response.errors))
                : setUser({username: '', password: ''});

            window.localStorage.setItem("isLoggedIn", true);
            window.location.href = "/dashboard";
        }
    };

    return (
        <Fragment>

            <div className="m-auto align-self-center" style={{width: '70%'}}>

                <h1 className="text-center my-3">Login</h1>

                <Form onSubmit={handleSubmit}>

                    <div className="m-auto align-self-center"
                         style={{width: '50%'}}>

                        <FormGroup>
                            <Label>
                                Username:
                            </Label>
                            <Input
                                type='text'
                                placeholder='Enter Username'
                                name='username'
                                id='username'
                                value={user.username}
                                onChange={onChange}/>
                            <p style={{color: 'red'}}>
                                {formValidation.username}
                            </p>
                        </FormGroup>
                    </div>

                    <div className="m-auto align-self-center"
                         style={{width: '50%'}}>
                        <FormGroup>
                            <Label>
                                Password:
                            </Label>
                            <Input
                                type='text'
                                placeholder='Enter Password'
                                name='password'
                                value={user.password}
                                id='password'
                                onChange={onChange}/>
                            <p style={{color: 'red'}}>
                                {formValidation.password}
                            </p>
                        </FormGroup>
                    </div>

                    <Container className="text-center">
                        <Button
                            type="submit"
                            size="lg"
                            className="my-2"
                            style={{width: "20%"}}
                            color="dark">
                            Login
                        </Button>
                    </Container>
                </Form>
            </div>
        </Fragment>
    );
};