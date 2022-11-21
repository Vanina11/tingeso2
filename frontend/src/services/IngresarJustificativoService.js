import axios from 'axios';

const baseUrl = 'http://localhost:8080/justificativo';
const token = localStorage.getItem("react-token");

class IngresarJustificativoService {

    ingresarJustificativo(justificativo) {
        return axios.post(baseUrl, justificativo, {headers: {Authorization: `Bearer ${token}`}});
    }
}

export default new IngresarJustificativoService();