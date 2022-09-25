export const frontendValidationForLogin = (user) => {
    const errors = {};

    if (user.username === null || user.username === undefined || user.username == '') {
        errors.username = "Username is required";
    }

    if (user.password === null || user.password === undefined || user.password == '') {
        errors.password = "Password is required";
    }

    return errors;
}

export const apiValidationForLogin = (user) => {
    const errors = {};

    errors.username = user.username;
    errors.password = user.password;

    return errors;
}

export const frontendValidationForCustomerRegistration = (user) => {
    const errors = {};

    if (user.firstName === null || user.firstName === undefined || user.firstName == '') {
        errors.firstName = "First Name is required";
    }

    if (user.lastName === null || user.lastName === undefined || user.lastName == '') {
        errors.lastName = "Last Name is required";
    }

    if (user.username === null || user.username === undefined || user.username == '') {
        errors.username = "Username is required";
    }

    if (user.password === null || user.password === undefined || user.password == '') {
        errors.password = "Password is required";
    }

    if (user.address === null || user.address === undefined || user.address == '') {
        errors.address = "Address is required";
    }

    return errors;
}

export const apiValidationForCustomerRegistration = (user) => {
    const errors = {};

    errors.firstName = user.firstName;
    errors.lastName = user.lastName;
    errors.username = user.username;
    errors.password = user.password;
    errors.address = user.address;

    return errors;
}