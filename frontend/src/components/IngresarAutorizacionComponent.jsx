import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";

class IngresarAutorizacionComponent extends Component {
  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Card className="container card ">
          <Card.Body>
            <Card.Title>Ingresar autorización</Card.Title>
            <Card.Text>
              Ingresar una autorización para las horas extras trabajadas por un empleado.
              <br />
              <br />
              <Form>
      <Form.Group className="mb-3" controlId="rut">
        <Form.Label as="h6">Rut</Form.Label>
        <Form.Control type="rut" placeholder="Ingrese el rut del empleado XX.XXX.XXX-X" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="fecha">
        <Form.Label as="h6">Fecha de la ausencia</Form.Label>
        <Form.Control type="fecha" placeholder="Ingrese la fecha AAAA/MM/DD" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="horas">
        <Form.Label as="h6">Cantidad de horas extra</Form.Label>
        <Form.Control type="horas" placeholder="Ingrese la cantidad de horas extra" />
      </Form.Group>
    </Form>
            </Card.Text>
            <br />
            <Button className="boton">
                <img src="/upload.png" alt="upload" width="20" height="20" className="d-inline-block align-top upload img-fluid" />{' '}
                Ingresar</Button>
          </Card.Body>
        </Card>
      </div>
    );
  }
}

export default IngresarAutorizacionComponent;
