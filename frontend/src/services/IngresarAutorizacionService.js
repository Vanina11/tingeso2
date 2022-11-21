import axios from 'axios';

const baseUrl = 'http://localhost:8080/autorizacion';
const token = localStorage.getItem('react-token');

class IngresarAutorizacionService {
    
        ingresarAutorizacion(autorizacion) {
            return axios.post(baseUrl, autorizacion, {headers: {Authorization: `Bearer ${token}`}});
        }
    }

export default new IngresarAutorizacionService();