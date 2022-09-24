import React, {Fragment, useEffect, useState} from "react";
import {Button, Container, Form, FormGroup, Input, Label} from "reactstrap";

import {registerUser} from "../../api/UserApi";
import {registerUserUrl} from "../../resource/Url";

export default function RegistrationForm() {
    const [user, setUser] = useState({});

    useEffect(() => {
        document.title = "GamingHub | Register";
    }, []);

    const onChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    };


    const handleSubmit = async (event) => {
        event.preventDefault();
        let response = await registerUser(registerUserUrl, user);
    };

    return (
        <Fragment>

            <div className="m-auto align-self-center" style={{width: '70%'}}>

                <h1 className="text-center my-3">Register</h1>

                <Form onSubmit={handleSubmit}>

                    <div className="m-auto align-self-center"
                         style={{width: '50%'}}>

                        <FormGroup>
                            <Label>
                                First Name:
                            </Label>
                            <Input
                                type='text'
                                placeholder='Enter First Name'
                                name='firstName'
                                id='firstName'
                                value={user.firstName}
                                onChange={onChange}/>
                        </FormGroup>
                    </div>

                    <div className="m-auto align-self-center"
                         style={{width: '50%'}}>

                        <FormGroup>
                            <Label>
                                Last Name:
                            </Label>
                            <Input
                                type='text'
                                placeholder='Enter Last Name'
                                name='lastName'
                                id='lastName'
                                value={user.lastName}
                                onChange={onChange}/>
                        </FormGroup>
                    </div>

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

                    <div className="m-auto align-self-center"
                         style={{width: '50%'}}>
                        <FormGroup>
                            <Label>
                                Address:
                            </Label>
                            <Input
                                type='text'
                                placeholder='Enter Address'
                                name='address'
                                value={user.address}
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
                            color="dark">
                            Register
                        </Button>
                    </Container>
                </Form>
            </div>
        </Fragment>
    );
};