import React, {useEffect, useState} from 'react';


import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import Menu from './components/Menu';
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

export interface ICarta{
    id: any
    nombreRestaurante: string
}


const App: React.FC = () => {
    const [pedido, setPedido] = useState<IPedido[]>([])
    const [restaurante, setRestaurante] = useState<IRestaurante[]>([])
    const [carta, setCarta] = useState<ICarta[]>([])



    // useEffect(() => {
    //     const options = {method: 'GET'}

    //     fetch("http://localhost:8080/restaurantes/restauranteForm", options)
    //         .then(response => response.json())
    //         .then(fetchedRestaurante => setRestaurante(fetchedRestaurante))
    //         .catch(error => {
    //             console.log(error)
    //             alert("No se encuentran los restaurantes")
    //         })
    // }, [])

    useEffect(() => {
        const options = {method: 'GET'}

        fetch("http://localhost:8080/carta/todas", options)
            .then(response => response.json())
            .then(fetchedCarta => setCarta(fetchedCarta))
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
            <Menu></Menu>
           {<ListaRestaurantes setRestaurante={setRestaurante} restaurante={restaurante} carta={carta} setCarta={setCarta}/>}
        </div>
    );
}

export default App;