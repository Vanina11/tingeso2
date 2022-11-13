import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CargarArchivoComponent from "./components/CargarArchivoComponent";
import IngresarJustificativoComponent from "./components/IngresarJustificativoComponent";
import IngresarAutorizacionComponent from "./components/IngresarAutorizacionComponent";
import InicioComponent from "./components/InicioComponent";
import CalcularSueldosComponent from "./components/CalcularSueldosComponent";
import IngresarEmpleadoComponent from "./components/IngresarEmpleadoComponent";
import LimpiarRegistrosComponent from "./components/LimpiarRegistrosComponent";
import MostrarSueldosComponent from "./components/MostrarSueldosComponent";
import LoginService from "./services/LoginService";
import { ReactKeycloakProvider } from "@react-keycloak/web";
import keycloak from "./keycloak";
import PrivateRoute from "./helpers/PrivateRoute";


function App() {

  return (
    <div>
      <ReactKeycloakProvider initOptions={{ onLoad: 'login-required' }} authClient={keycloak} >
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
          <Route path="/login" element={<LoginService />} />
          <Route
             path="/secured"
             element={
               <PrivateRoute>
                 <LoginService />
               </PrivateRoute>
             }/>
        </Routes>
      </BrowserRouter>
      </ReactKeycloakProvider>
    </div>
  );
}

export default App;
