import React, {useEffect, useState} from 'react';
import PedidoEntradaComponente from "./components/PedidoEntradaComponente";
import PedidoListaComponente from "./components/PedidoListaComponente";
import Container from 'react-bootstrap/Container';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons

export interface IPedido {
    id: any
    platos : []
    precio: number
    estado : string
}

const App: React.FC = () => {
    const [pedido, setPedido] = useState<IPedido[]>([])

    useEffect(() => {
        const options = {method: 'GET'}

        fetch("http://localhost:8080/pedido/todos", options)
            .then(response => response.json())
            .then(fetchedPedido => setPedido(fetchedPedido))
            .catch(error => {
                console.log(error)
                alert("No se encuentran los pedidos")
            })
    }, [])

    return (
        <div className="App">
            <main>
                <Container>
                    <h1 className={"display-1 text-center"}>Pedidos</h1>
                    {<PedidoEntradaComponente setPedido={setPedido}/> }
                    <PedidoListaComponente setPedido={setPedido} pedido={pedido}/>
                </Container>
            </main>
        </div>
    );
}

export default App;