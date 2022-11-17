
export class CartaService {

    getCartas() {

        return fetch('http://localhost:8080/carta/todas').then(res => res.json()).then(d => d.data);
    }


}

export default CartaService;