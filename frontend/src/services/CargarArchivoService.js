import axios from "axios";

const API_URL = "http://localhost:8080/marcas-reloj/subir-archivo";

class CargarArchivoService {
    cargarArchivo(archivo) {
        return axios.put(API_URL, archivo);
    }
}

export default new CargarArchivoService();