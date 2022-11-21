import axios from "axios";

const url = "http://localhost:8080/empleado";
const token = localStorage.getItem("token");

class IngresarEmpleadoService {
    
    ingresarEmpleado(empleado) {
        return axios.post(url, empleado, {headers: {Authorization: `Bearer ${token}`}});
    }
    /*
    ingresarEmpleado(empleado) {
        return axios.post(url, empleado);
    }*/
}

export default new IngresarEmpleadoService();
