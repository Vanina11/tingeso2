import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import IngresarAutorizacionService from "../services/IngresarAutorizacionService";

class IngresarAutorizacionComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rut: "",
      fecha: "",
      horas: ""
    }
    this.changeRutHandler = this.changeRutHandler.bind(this);
    this.changeFechaHandler = this.changeFechaHandler.bind(this);
    this.changeHorasHandler = this.changeHorasHandler.bind(this);
  }

  changeRutHandler = (event) => {
    this.setState({ rut: event.target.value });
  }

  changeFechaHandler = (event) => {
    this.setState({ fecha: event.target.value });
  }

  changeHorasHandler = (event) => {
    this.setState({ horas: event.target.value });
  }

  ingresarAutorizacion = (e) => {
    e.preventDefault();
    let autorizacion = { rut: this.state.rut, fecha: this.state.fecha, horas: this.state.horas };
    console.log("autorizacion => " + JSON.stringify(autorizacion));
    IngresarAutorizacionService.ingresarAutorizacion(autorizacion).then(res => {
      this.props.history.push('/');
    });
  }

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
      <Form.Group className="mb-3" controlId="rut" onChange={this.changeRutHandler}>
        <Form.Label as="h6">Rut</Form.Label>
        <Form.Control type="rut" placeholder="Ingrese el rut del empleado XX.XXX.XXX-X" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="fecha" onChange={this.changeFechaHandler}>
        <Form.Label as="h6">Fecha de la ausencia</Form.Label>
        <Form.Control type="fecha" placeholder="Ingrese la fecha AAAA/MM/DD" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="horas" onChange={this.changeHorasHandler}>
        <Form.Label as="h6">Cantidad de horas extra</Form.Label>
        <Form.Control type="horas" placeholder="Ingrese la cantidad de horas extra" />
      </Form.Group>
    </Form>
            </Card.Text>
            <br />
            <Button className="boton" onClick={this.ingresarAutorizacion}>
                <img src="/upload.png" alt="upload" width="20" height="20" className="d-inline-block align-top upload img-fluid" />{' '}
                Ingresar</Button>
          </Card.Body>
        </Card>
      </div>
    );
  }
}

export default IngresarAutorizacionComponent;
