import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import IngresarEmpleadoService from "../services/IngresarEmpleadoService";

class IngresarEmpleadoComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rut: "",
            nombres: "",
            apellidos: "",
            fechaNacimiento: "",
            fechaIngreso: "",
            categoria: ""
        };
        this.changeRutHandler = this.changeRutHandler.bind(this);
        this.changeNombresHandler = this.changeNombresHandler.bind(this);
        this.changeApellidosHandler = this.changeApellidosHandler.bind(this);
        this.changeFechaNacimientoHandler = this.changeFechaNacimientoHandler.bind(this);
        this.changeFechaIngresoHandler = this.changeFechaIngresoHandler.bind(this);
        this.changeCategoriaHandler = this.changeCategoriaHandler.bind(this);
    }

    changeRutHandler = (event) => {
        this.setState({ rut: event.target.value });
        console.log(this.state.rut);
    };

    changeNombresHandler = (event) => {
        this.setState({ nombres: event.target.value });
        console.log(this.state.nombres);
    };

    changeApellidosHandler = (event) => {
        this.setState({ apellidos: event.target.value });
        console.log(this.state.apellidos);
    };

    changeFechaNacimientoHandler = (event) => {
        this.setState({ fechaNacimiento: event.target.value });
        console.log(this.state.fechaNacimiento);
    };

    changeFechaIngresoHandler = (event) => {
        this.setState({ fechaIngreso: event.target.value });
        console.log(this.state.fechaIngreso);
    };

    changeCategoriaHandler  = (event) => {
        this.setState({ categoria: event.target.value });
        console.log(this.state.categoria);
    };

    ingresarEmpleado = (e) => {
        e.preventDefault();
        let empleado = { rut: this.state.rut, nombres: this.state.nombres, apellidos: this.state.apellidos, fechaNacimiento: this.state.fechaNacimiento, fechaIngreso: this.state.fechaIngreso, categoria: this.state.categoria };
        console.log("empleado => " + JSON.stringify(empleado));
        IngresarEmpleadoService.ingresarEmpleado(empleado).then(
            (res) => {
                window.location.href="/";
            }
        ).catch((error) => {
            window.location.href="/error";
        });
    };

    volverInicio = (e) => {
        e.preventDefault();
        window.location.href="/";
      };

    render() {
        return (
          <div className="home">
            <NavbarComponent />
            <Card className="container card ">
              <Card.Body>
                <Card.Title>Ingresar empleado</Card.Title>
                <Card.Text>
                  <p>Ingresar los datos de un nuevo empleado.</p>
                  <Form>
                    <Form.Group
                      className="mb-3"
                      controlId="rut"
                      onChange={this.changeRutHandler}
                    >
                      <Form.Label as="h6">Rut</Form.Label>
                      <Form.Control
                        type="rut"
                        placeholder="Ingrese el rut del empleado XX.XXX.XXX-X"
                      />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="nombres"
                      onChange={this.changeNombresHandler}
                    >
                      <Form.Label as="h6">Nombres</Form.Label>
                      <Form.Control
                        type="nombres"
                        placeholder="Ingrese los nombres del empleado"
                      />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="apellidos"
                      onChange={this.changeApellidosHandler}
                    >
                      <Form.Label as="h6">Apellidos</Form.Label>
                      <Form.Control
                        type="nombres"
                        placeholder="Ingrese los apellidos del empleado"
                      />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="fechaNacimiento"
                      onChange={this.changeFechaNacimientoHandler}
                    >
                      <Form.Label as="h6">Fecha de nacimiento</Form.Label>
                      <Form.Control
                        type="fecha"
                        placeholder="Ingrese la fecha AAAA/MM/DD"
                      />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="fechaIngreso"
                      onChange={this.changeFechaIngresoHandler}
                    >
                      <Form.Label as="h6">Fecha de ingreso a la empresa</Form.Label>
                      <Form.Control
                        type="fecha"
                        placeholder="Ingrese la fecha AAAA/MM/DD"
                      />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="categoria"
                      onChange={this.changeCategoriaHandler}
                    >
                      <Form.Label as="h6">Categoria</Form.Label>
                      <Form.Control
                        type="fecha"
                        placeholder="Ingrese la categoría A, B o C"
                      />
                    </Form.Group>
                  </Form>
                </Card.Text>
                <br />
                <div className="d-flex justify-content-between">
                <Button className="boton" onClick={this.ingresarEmpleado}>
                  <img
                    src="/upload.png"
                    alt="upload"
                    width="20"
                    height="20"
                    className="d-inline-block align-top upload img-fluid"
                  />{" "}
                  Ingresar
                </Button>
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
                </div>
              </Card.Body>
            </Card>
          </div>
        );
      }
    }

    export default IngresarEmpleadoComponent;