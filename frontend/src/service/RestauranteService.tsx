
export class RestauranteService {

    getRestaurantes() {
        return fetch('http://localhost:8080/restaurantes/restauranteForm').then(res => res.json());
    }


}

export default RestauranteService;