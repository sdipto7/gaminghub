import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function CustomNavbar() {
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="#dashboard-link">GAMINGHUB</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#game-list-link">Games</Nav.Link>
                    </Nav>
                    <Nav>
                        <Nav.Link href="#Cart-link">Shopping Cart</Nav.Link>
                        <NavDropdown title="Account" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#account-info-link">My Account</NavDropdown.Item>
                            <NavDropdown.Item href="#change-pass-link">Change Password</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#logout-link">Logout</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default CustomNavbar;