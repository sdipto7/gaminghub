import React, {Fragment, useEffect, useState} from "react";
import {Button, Container, Form, FormGroup, Input, Label} from "reactstrap";

import {registerCustomer} from "../../api/UserApi";
import {registerCustomerUrl} from "../../resource/Url";
import {
    frontendValidationForCustomerRegistration,
    apiValidationForCustomerRegistration
} from "../../validator/UserValidator";

export default function RegistrationForm() {
    const [user, setUser] = useState({});
    const [formValidation, setFormValidation] = useState({});

    useEffect(() => {
        document.title = "GamingHub | Register";
    }, []);

    const onChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    };


    const handleSubmit = async (event) => {
        event.preventDefault();

        setFormValidation(frontendValidationForCustomerRegistration(user));

        if (Object.keys(formValidation).length === 0) {
            let response = await registerCustomer(registerCustomerUrl, user);

            response.hasError ?
                setFormValidation(apiValidationForCustomerRegistration(response.errors))
                : setUser({firstName: '', lastName: '', username: '', password: '', address: ''});

            window.location.href = "/";
        }
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
                            <p style={{color: 'red'}}>
                                {formValidation.firstName}
                            </p>
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
                            <p style={{color: 'red'}}>
                                {formValidation.lastName}
                            </p>
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
                            <p style={{color: 'red'}}>
                                {formValidation.address}
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
                            Register
                        </Button>
                    </Container>
                </Form>
            </div>
        </Fragment>
    );
};