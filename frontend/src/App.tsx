import React, {useEffect, useState} from 'react';
import PedidoEntradaComponente from "./components/Pedidos/PedidoEntradaComponente";
import PedidoListaComponente from "./components/Pedidos/PedidoListaComponente";
import Container from 'react-bootstrap/Container';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import Menu from './components/Menu';
import MenuRider from './components/Rider/RiderNavBar'
 
import ListaRestaurantes from './components/Restaurantes/ListaRestaurantes';



export interface IPedido {
    id: any
    platos : []
    precio: number
    estado : string
}

export interface IRestaurante{

    nombre: string
    razon: string
    cif: string
    direccion:string
    tlf: string
    categoria: string
}

const App: React.FC = () => {
    const [pedido, setPedido] = useState<IPedido[]>([])
    const [restaurante, setRestaurante] = useState<IRestaurante[]>([])


    useEffect(() => {
        const options = {method: 'GET'}

        fetch("http://localhost:8080/restaurantes/restauranteForm", options)
            .then(response => response.json())
            .then(fetchedRestaurante => setRestaurante(fetchedRestaurante))
            .catch(error => {
                console.log(error)
                alert("No se encuentran los restaurantes")
            })
    }, [])

    // useEffect(() => {
    //     const options = {method: 'GET'}

    //     fetch("http://localhost:8080/pedido/todos", options)
    //         .then(response => response.json())
    //         .then(fetchedPedido => setPedido(fetchedPedido))
    //         .catch(error => {
    //             console.log(error)
    //             alert("No se encuentran los pedidos")
    //         })
    // }, [])
 
    return (
        <div className="App">
           {/*  <Menu></Menu>
           {<ListaRestaurantes setRestaurante={setRestaurante} restaurante={restaurante}/>} */}
            <MenuRider/>
        </div>
    );
}

export default App;