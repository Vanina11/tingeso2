import axios from "axios";

const baseUrl = "http://localhost:8080/sueldos/eliminar";

class LimpiarRegistrosService {
    limpiarRegistros() {
        return axios.get(baseUrl);
    }
}

export default new LimpiarRegistrosService();
