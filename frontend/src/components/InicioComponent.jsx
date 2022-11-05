import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import CalcularSueldosService from "../services/CalcularSueldosService";
import LimpiarRegistroService from "../services/LimpiarRegistroService";

class InicioComponent extends Component {

  cargarArchivo = (e) => {
    e.preventDefault();
    window.location.href="/cargar-archivo";
  };

  calcularSueldos = (e) => {
    e.preventDefault();
    CalcularSueldosService.calcularSueldos().then((res) => {
      window.location.href="/calcular-sueldos";
    });
  };

  mostrarPlanilla = (e) => {
    e.preventDefault();
    window.location.href="/mostrar-planilla";
  };

  ingresarAutorizacion = (e) => {
    e.preventDefault();
    window.location.href="/ingresar-autorizacion";
  };

  ingresarJustificativo = (e) => {
    e.preventDefault();
    window.location.href="/ingresar-justificativo";
  };

  ingresarEmpleado = (e) => {
    e.preventDefault();
    window.location.href="/ingresar-empleado";
  };

  limpiarRegistros = (e) => {
    e.preventDefault();
    LimpiarRegistroService.limpiarRegistros().then((res) => {
      window.location.href="/limpiar-registros";
    });
  };

  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <div className="d-flex justify-content-around">
          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/marcasreloj.svg"/>
            <Card.Body>
            <Card.Text>
            Subir marcas de reloj de los empleados durante un mes.
          </Card.Text >
              <Button variant="primary boton" onClick={this.cargarArchivo}>Cargar marcas de reloj</Button>
            </Card.Body>
          </Card>

          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/calcular.svg" />
            <Card.Body>
            <Card.Text>
            Calcular sueldos del mes de empleados.
          </Card.Text >
              <Button variant="primary boton" onClick={this.calcularSueldos}>Calcular sueldos</Button>
            </Card.Body>
          </Card>

          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/mostrar.svg"/>
            <Card.Body>
            <Card.Text>
            Mostrar sueldos del mes de empleados.
          </Card.Text >
              <Button variant="primary boton" onClick={this.mostrarPlanilla}>Mostrar sueldos</Button>
            </Card.Body>
          </Card>
        </div>

        <div className="d-flex justify-content-around">
          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/autorizacion.svg"/>
            <Card.Body>
            <Card.Text>
           Ingresar autorización a horas extras de un empleado.
          </Card.Text >
              <Button variant="primary boton" onClick={this.ingresarAutorizacion}>Ingresar autorización</Button>
            </Card.Body>
          </Card>

          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/justificativo.svg" />
            <Card.Body>
            <Card.Text>
           Ingresar justificativo a ausencia de un empleado.
          </Card.Text >
              <Button variant="primary boton" onClick={this.ingresarJustificativo}>Ingresar justificativo</Button>
            </Card.Body>
          </Card>

          <Card className="text-center" style={{ width: "15rem" }}>
            <Card.Img variant="top" src="/gestion.svg" />
            <Card.Body>
              <Button variant="primary boton" onClick={this.ingresarEmpleado}>Ingresar empleado</Button>
              <br />
              <br />
              <Button variant="primary boton2" onClick={this.limpiarRegistros}>Limpiar registros</Button>
            </Card.Body>
          </Card>
        </div>
      </div>
    );
  }
}

export default InicioComponent;
