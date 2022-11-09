import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import CargarArchivoService from "../services/CargarArchivoService";

class CargarArchivoComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      file: null,
    };
    this.onFileChange = this.onFileChange.bind(this);
  }

  onFileChange(event) {
    this.setState({ file: event.target.files[0] });
  }

  onFileUpload = () => {
    const formData = new FormData();
    formData.append("file", this.state.file);
    CargarArchivoService.cargarArchivo(formData).then((res) => {
      window.location.href = "/";
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
            <Card.Title>Subir archivo</Card.Title>
            <Card.Text>
              <Form.Group className="mb-3" controlId="file">
                <Form.Control type="file" onChange={this.onFileChange} />
                <Form.Text className="text-muted">
                  El archivo debe cumplir con el formato establecido y la extensión de un documento de texto.
                </Form.Text>
              </Form.Group>
            </Card.Text>
            <div className="d-flex justify-content-between">
            <Button className="boton" onClick={this.onFileUpload}>
                <img src="/upload.png" alt="upload" width="20" height="20" className="d-inline-block align-top upload img-fluid" />{' '}
                Subir</Button>
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

export default CargarArchivoComponent;
