import './App.css';

import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './component/Home';
import {Row, Col, Container} from "react-bootstrap";
import Header from './component/Header';
import Menu from './component/Menu';
import CustomNavbar from "./component/CustomNavbar";
import Dashboard from './component/Dashboard';
import ProtectedRoute from "./component/ProtectedRoute";
import RegistrationForm from "./component/user/RegistrationForm"
import LoginForm from "./component/user/LoginForm";

function App() {

    const isLoggedIn = window.localStorage.getItem("isLoggedIn");

    return (
        <div className="App">
            <Router>
                {/*<Container>*/}
                {isLoggedIn ?
                    <div>
                        <CustomNavbar />
                        <Row>
                            <Col md={3}>
                                {/*<Menu/>*/}
                            </Col>

                            <Col md={9}>
                                <Routes>
                                    <Route element={<ProtectedRoute forRole={"Dashboard View"}/>}>
                                    <Route path="/dashboard" element={<Dashboard/>}/>
                                    </Route>
                                </Routes>
                            </Col>
                        </Row>
                    </div> :
                    <div>
                        <Header/>
                        <Routes>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/register" element={<RegistrationForm/>}></Route>
                            <Route path="/login" element={<LoginForm/>}></Route>
                        </Routes>
                    </div>
                }
                {/*</Container>*/}
            </Router>
        </div>
    );
}

export default App;
