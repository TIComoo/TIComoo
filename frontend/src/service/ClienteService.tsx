export class ClienteService{

    getCliente(){
        return fetch('http://localhost:8080/cliente/leerClientePorEmail').then(res =>res.json());
    }
}