import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CargarArchivoComponent from "./components/CargarArchivoComponent";
import IngresarJustificativoComponent from "./components/IngresarJustificativoComponent";
import IngresarAutorizacionComponent from "./components/IngresarAutorizacionComponent";
import InicioComponent from "./components/InicioComponent";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<InicioComponent />} />
          <Route path="/cargar-archivo" element={<CargarArchivoComponent />} />
          <Route path="/ingresar-justificativo" element={<IngresarJustificativoComponent />} />
          <Route path="/ingresar-autorizacion" element={<IngresarAutorizacionComponent />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
