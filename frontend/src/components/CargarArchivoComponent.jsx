import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";

class CargarArchivoComponent extends Component {
  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Card className="container card ">
          <Card.Body>
            <Card.Title>Subir archivo</Card.Title>
            <Card.Text>
              Seleccione el archivo con las marcas de reloj.
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Control type="archivo" placeholder="Enter email" />
                <Form.Text className="text-muted">
                  El archivo debe cumplir con el formato establecido y la extensión de un documento de texto.
                </Form.Text>
              </Form.Group>
            </Card.Text>
            <Button className="boton">
                <img src="/upload.png" alt="upload" width="20" height="20" className="d-inline-block align-top upload img-fluid" />{' '}
                Subir</Button>
          </Card.Body>
        </Card>
      </div>
    );
  }
}

export default CargarArchivoComponent;
