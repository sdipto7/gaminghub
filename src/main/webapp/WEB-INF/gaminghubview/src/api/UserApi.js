import axios from "axios";

export const findUserForLogin = (url, user) => {

    return new Promise((resolve, reject) => {
        axios.post(`${url}`, JSON.stringify({username: user.username, password: user.password}), {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        ).then((result) => {
            console.log(result)
            resolve({hasError: false});
        }, (error) => {
            resolve({hasError: true, errors: error.response.data});
        })
    });
};