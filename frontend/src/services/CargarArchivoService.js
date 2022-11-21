import axios from "axios";

const API_URL = "http://localhost:8080/marcas-reloj/subir-archivo";
const token = localStorage.getItem('react-token');

class CargarArchivoService {
    cargarArchivo(archivo) {
        return axios.put(API_URL, archivo, { headers: { Authorization: `Bearer ${token}` } });
    }
}

export default new CargarArchivoService();