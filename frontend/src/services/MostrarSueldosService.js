import axios from "axios";

const API_URL = "http://localhost:8080/sueldos/mostrar-sueldos";

class MostrarSueldosService {
    getSueldos() {
        return axios.get(API_URL);
    }
}

export default new MostrarSueldosService();