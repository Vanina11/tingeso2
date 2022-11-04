import axios from 'axios';

const baseUrl = 'http://localhost:8080/autorizacion';

class IngresarAutorizacionService {
    
        ingresarAutorizacion(autorizacion) {
            return axios.post(baseUrl, autorizacion);
        }
    }

export default new IngresarAutorizacionService();