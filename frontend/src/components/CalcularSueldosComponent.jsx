import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

class InicioComponent extends Component {
  volverInicio = (e) => {
    e.preventDefault();
    window.location.href = "/";
  };

  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Card
          className="text-center container card2"
          style={{ width: "50rem" }}
        >
          <div className="d-flex justify-content-center">
            <Card.Body>
              <img src="/autorizacion.svg" width="100" height="100" />
              <Card.Title>Calcular sueldos</Card.Title>
              <Card.Text>
                <br />
                <p>
                  Los sueldos de los empleados se han calculado correctamente.
                </p>
              </Card.Text>
              <br />
              <Button className="boton2" onClick={this.volverInicio}>
                <img
                  src="/volver.svg"
                  alt="upload"
                  width="20"
                  height="20"
                  className="d-inline-block align-top upload img-fluid"
                />{" "}
                Volver a inicio
              </Button>
            </Card.Body>
          </div>
        </Card>
      </div>
    );
  }
}

export default InicioComponent;
