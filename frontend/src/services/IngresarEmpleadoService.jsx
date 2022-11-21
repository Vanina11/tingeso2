import axios from "axios";

const url = "http://localhost:8080/empleado";

class IngresarEmpleadoService {
    
    ingresarEmpleado(empleado) {
        return axios.post(url, empleado);
    }
}

export default new IngresarEmpleadoService();
