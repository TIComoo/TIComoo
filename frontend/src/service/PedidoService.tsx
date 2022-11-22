export class PedidoService {



    enviarEleccion(json:string){
        return fetch('http://localhost:8080/pedido/crearPedido',{
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: json
        });
    }

    getIdMasAlto() {

        return fetch('http://localhost:8080/pedido/id');
    }

    getPedidos() {
        return fetch('http://localhost:8080/pedido/todos').then(res => res.json());
    }

    getPedidosEmail(json:string){
        return fetch('http://localhost:8080/pedido/email',{
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: json
        });
    }
    
    deletePedido( id:any){
        const options = { method: 'DELETE' }

        fetch("http://localhost:8080/pedido/"+id, options);
            
    }
}

export default PedidoService;