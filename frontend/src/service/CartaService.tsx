
export class CartaService {

    getCartas() {

        return fetch('http://localhost:8080/carta/todas').then(res => res.json());
    }

    getCartaElegida() {

        return fetch('http://localhost:8080/carta/eleccion')
    }


    enviarEleccion(carta:string){
        return fetch('http://localhost:8080/carta/enviar',{
            method: 'POST',
            body: carta
        });
    }


}

export default CartaService;