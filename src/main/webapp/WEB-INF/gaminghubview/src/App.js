import './App.css';

import {Container} from 'reactstrap';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './component/Home';
import {Row, Col} from "reactstrap";
import Header from './component/Header';
import Menu from './component/Menu';
import Dashboard from './component/Dashboard';
import ProtectedRoute from "./component/ProtectedRoute";
import RegistrationForm from "./component/user/RegistrationForm"
import LoginForm from "./component/user/LoginForm";

function App() {

    const isLoggedIn = window.localStorage.getItem("isLoggedIn");

    return (
        <div className="App">
            <Router>
                <Container>
                    <Header/>
                    {isLoggedIn ?
                        <Row>
                            <Col md={3}>
                                <Menu/>
                            </Col>

                            <Col md={9}>
                                <Routes>
                                    {/*<Route element={<ProtectedRoute forRole={"ROLE_ADMIN"}/>}>*/}
                                    <Route path="/" element={<Home/>}/>
                                    <Route path="/dashboard" element={<Dashboard/>}/>
                                    {/*</Route>*/}
                                </Routes>
                            </Col>
                        </Row> :
                        <div>
                            <Routes>
                                <Route path="/" element={<Home/>}/>
                                <Route path="/register" element={<RegistrationForm/>}></Route>
                                <Route path="/login" element={<LoginForm/>}></Route>
                            </Routes>
                        </div>
                    }
                </Container>
            </Router>
        </div>
    );
}

export default App;
