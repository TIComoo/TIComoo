import axios from 'axios';

export class RiderService {
    baseUrl = "http://localhost:8080/pedido/pedidosDisponibles";

    getAll(){
        return axios.get(this.baseUrl).then(res => res.data);
            
    }
    getRider(){
        return fetch('http://localhost:8080/rider/leerRiderPorEmail').then(res =>res.json());
    }
  /*   save(persona) {
        return axios.post(this.baseUrl + "save", persona).then(res => res.data);
    }

    delete(id) {
        return axios.get(this.baseUrl + "delete/"+id).then(res => res.data);
    } */
}