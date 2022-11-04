import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import IngresarJustificativoService from "../services/IngresarJustificativoService";

class IngresarJustificativoComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rut: "",
            fecha: ""
        }
        this.changeRutHandler = this.changeRutHandler.bind(this);
        this.changeFechaHandler = this.changeFechaHandler.bind(this);
    }

    changeRutHandler = (event) => {
        this.setState({ rut: event.target.value });
    }

    changeFechaHandler = (event) => {
        this.setState({ fecha: event.target.value });
    }

    ingresarJustificativo = (e) => {
        e.preventDefault();
        let justificativo = { rut: this.state.rut, fecha: this.state.fecha };
        console.log("justificativo => " + JSON.stringify(justificativo));
        IngresarJustificativoService.ingresarJustificativo(justificativo).then(res => {
            this.props.history.push('/');
        });
    }


  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Card className="container card ">
          <Card.Body>
            <Card.Title>Ingresar justificativo</Card.Title>
            <Card.Text>
              Ingresar un justificativo para la ausencia de un empleado.
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
    </Form>
            </Card.Text>
            <br />
            <Button className="boton" onClick={this.ingresarJustificativo}>
                <img src="/upload.png" alt="upload" width="20" height="20" className="d-inline-block align-top upload img-fluid" />{' '}
                Ingresar</Button>
          </Card.Body>
        </Card>
      </div>
    );
  }
}

export default IngresarJustificativoComponent;
