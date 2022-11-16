import axios from "axios";

const API_URL = "http://localhost:8080/sueldos/mostrar-sueldos";
const token = localStorage.getItem('react-token');

class MostrarSueldosService {
    async getSueldos() {
        return axios.get(API_URL, {headers: {Authorization: `Bearer ${token}`}});
    }
}

export default new MostrarSueldosService();