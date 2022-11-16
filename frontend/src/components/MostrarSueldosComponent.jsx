import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Table from "react-bootstrap/Table";
import MostrarSueldosService from "../services/MostrarSueldosService";

class MostrarSueldosComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      sueldos: [],
    };
  }

  async componentDidMount() {
    MostrarSueldosService.getSueldos().then((res) => {
      this.setState({ sueldos: res.data });
      console.log(this.state.sueldos);
    }).catch((error) => {
      window.location.href = "/error";
    });
  }

  volverInicio = (e) => {
    e.preventDefault();
    window.location.href = "/";
  };

  render() {
    return (
      <div className="home">
        <NavbarComponent />
        <Card className="container">
          <Card.Body>
            <Card.Title>Plantilla de sueldos</Card.Title>
            <Table striped hover className="borde-tabla">
              <thead>
                <tr>
                  <th>Rut</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>Categoría</th>
                  <th>Años de Servicio</th>
                  <th>Sueldo Fijo</th>
                  <th>Monto Bonificación</th>
                  <th>Monto Horas Extra</th>
                  <th>Monto Descuentos</th>
                  <th>Sueldo Bruto</th>
                  <th>Cotización Previsional</th>
                  <th>Cotización Salud</th>
                  <th>Sueldo Final</th>
                </tr>
              </thead>
              <tbody>
                {this.state.sueldos.map((sueldo) => (
                  <tr key={sueldo.rut}>
                    <td>{sueldo.rut}</td>
                    <td>{sueldo.nombres}</td>
                    <td>{sueldo.apellidos}</td>
                    <td>{sueldo.categoria}</td>
                    <td>{sueldo.aniosServicio}</td>
                    <td>{sueldo.sueldoFijo}</td>
                    <td>{sueldo.montoBonificacion}</td>
                    <td>{sueldo.montoHorasExtra}</td>
                    <td>{sueldo.montoDescuentos}</td>
                    <td>{sueldo.sueldoBruto}</td>
                    <td>{sueldo.cotizacionPrevisional}</td>
                    <td>{sueldo.cotizacionSalud}</td>
                    <td>{sueldo.sueldoFinal}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <div className="d-flex justify-content-between">
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

export default MostrarSueldosComponent;
