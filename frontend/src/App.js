import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CargarArchivoComponent from "./components/CargarArchivoComponent";
import IngresarJustificativoComponent from "./components/IngresarJustificativoComponent";
import IngresarAutorizacionComponent from "./components/IngresarAutorizacionComponent";
import InicioComponent from "./components/InicioComponent";
import IngresarEmpleadoComponent from "./components/IngresarEmpleadoComponent";
import LimpiarRegistrosComponent from "./components/LimpiarRegistrosComponent";
import MostrarSueldosComponent from "./components/MostrarSueldosComponent";
import ErrorComponent from "./components/ErrorComponent";
import CalcularSueldosComponent from "./components/CalcularSueldosComponent";


function App() {

  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<InicioComponent />} />
          <Route path="/cargar-archivo" element={<CargarArchivoComponent />} />
          <Route path="/ingresar-justificativo" element={<IngresarJustificativoComponent />} />
          <Route path="/ingresar-autorizacion" element={<IngresarAutorizacionComponent />} />
          <Route path="/calcular-sueldos" element={<CalcularSueldosComponent />} />
          <Route path="/ingresar-empleado" element={<IngresarEmpleadoComponent />} />
          <Route path="/limpiar-registros" element={<LimpiarRegistrosComponent />} />
          <Route path="/mostrar-planilla" element={<MostrarSueldosComponent />} />
          <Route path="/error" element={<ErrorComponent />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
