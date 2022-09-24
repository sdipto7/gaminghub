import React, {useEffect, useState} from "react";
import {Container, Form, FormGroup, Input, Label, Button} from "reactstrap";

import {Fragment} from "react";
import {findUserForLogin} from "../../api/UserApi";
import {findUserUrl} from "../../resource/Url";

export default function LoginForm() {
    const [user, setUser] = useState({});

    useEffect(() => {
        document.title = "GamingHub | Login";
    }, []);

    const onChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    };


    const handleSubmit = async (event) => {
        event.preventDefault();
        let response = await findUserForLogin(findUserUrl, user);
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
                        </FormGroup>
                    </div>

                    <Container className="text-center">
                        <Button
                            type="submit"
                            size="lg"
                            className="my-2"
                            style={{width: "20%"}}
                            color="success">
                            Login
                        </Button>
                    </Container>
                </Form>
            </div>
        </Fragment>
    );
};