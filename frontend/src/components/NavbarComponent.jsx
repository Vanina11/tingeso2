import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

function NavbarComponent() {
  const name = localStorage.getItem("name");
  return (
    <>
      <Navbar className="navbar">
        <Container>
          <Navbar.Brand href="#home">
            <img
            alt=""
            src="/logo.png"
            width="30"
            height="30"
            className="d-inline-block align-top logo img-fluid"
            />{' '}
            Muebles Stgo
            ${name}

          </Navbar.Brand>
        </Container>
      </Navbar>
    </>
  );
}

export default NavbarComponent;
