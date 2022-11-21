
export class PlatoService {

    getPlatos() {

        return fetch('http://localhost:8080/plato/platos');
    }


}

export default PlatoService;