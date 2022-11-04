import axios from 'axios';

const baseUrl = 'http://localhost:8080/justificativo';

class IngresarJustificativoService {

    ingresarJustificativo(justificativo) {
        return axios.post(baseUrl, justificativo);
    }
}

export default new IngresarJustificativoService();