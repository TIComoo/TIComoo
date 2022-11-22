export class ClienteService{

    getCliente(){
        return fetch('http://localhost:8080/cliente/leerClientePorEmail').then(res =>res.json());
    }

    
    getClienteEmail(json :string){
        return fetch('http://localhost:8080/cliente/leerClientePorEmail',{
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: json
    });
}

}

