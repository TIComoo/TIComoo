
export class CartaService {

    getCartas() {

        return fetch('http://localhost:8080/restaurantes/restauranteForm').then(res => res.json()).then(d => d.data);
    }


}

export default CartaService;