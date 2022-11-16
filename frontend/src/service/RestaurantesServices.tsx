
export class RestauranteService {

    getRestaurantes() {
        return fetch('http://localhost:8080/restaurantes/restauranteForm').then(res => res.json()).then(d => d.data);
    }


}

export default RestauranteService;