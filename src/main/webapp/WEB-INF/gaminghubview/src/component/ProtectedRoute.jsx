import {Navigate, Outlet} from 'react-router-dom';

const ProtectedRoute = (forRole) => {
    const redirectPath = '/';
    const isLoggedIn = window.localStorage.getItem("isLoggedIn");
    const role = window.localStorage.getItem("role");

    if (isLoggedIn && role === forRole) {
        return <Outlet/>;
    }

    return (
        <Navigate to={redirectPath} replace/>
    );
};

export default ProtectedRoute;