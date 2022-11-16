import axios from 'axios';

const baseUrl = 'http://localhost:8080/sueldos';
const token = localStorage.getItem('react-token');

class CalcularSueldosService {
    
        calcularSueldos() {
            return axios.get(baseUrl, {headers: {Authorization: `Bearer ${token}`}});
        }
}

export default new CalcularSueldosService();
