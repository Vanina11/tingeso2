import axios from 'axios';

const baseUrl = 'http://localhost:8080/sueldos';

class CalcularSueldosService {
    
        calcularSueldos() {
            return axios.get(baseUrl);
        }
}

export default new CalcularSueldosService();
