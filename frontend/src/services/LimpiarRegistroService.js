import axios from "axios";

const baseUrl = "http://localhost:8080/sueldos/eliminar";
const token = localStorage.getItem("react-token");

class LimpiarRegistrosService {
    limpiarRegistros() {
        return axios.get(baseUrl, { headers: { Authorization: `Bearer ${token}` } });
    }
}

export default new LimpiarRegistrosService();
