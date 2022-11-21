import React, {useEffect, useState} from 'react';




import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons


import Login from './components/Login';
import Restaurante from './components/Restaurantes/ListaRestaurantes';
import Carta from './components/Carta/CartaComponente';
import Pagar from './components/Pedidos/PagarPedido';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
/* import Pedidos from '../../components/Rider/Pedidos';
import Historial from '../../components/Rider/Historial';
import Cuenta from '../../components/Rider/Cuenta';
import Valoraciones from '../../components/Rider/Valoraciones'; */
import Salir from './components/Rider/Salir';



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
    cartaElegida: string
}

export interface IPlato{

    nombre: string
    nombreRestaurante: string
    categoria: string
    imagen: string
    descripcion: string
    precio: any
    aptoVeganos: string
}

const App: React.FC = () => {
    const [restaurante, setRestaurante] = useState<IRestaurante[]>([])
    const [carta, setCarta] = useState<ICarta[]>([]) 
    const [platos, setPlatos] = useState<IPlato[]>([])   
    const [pedidos, setPedidos] = useState<IPedido[]>([])
   
    return (
        <div className="App">
           {/*  <Menu></Menu>
           {<ListaRestaurantes setRestaurante={setRestaurante} restaurante={restaurante}/>} */}
           
            <BrowserRouter>
                <Routes>
                <Route path='/pedidos' element={<Pedidos/>}/>
                    <Route path='/historial' element={<Historial/>}/>
                    <Route path='/cuenta/:email' element={<Cuenta/>}/>
                    <Route path='/valoraciones/{}' element={<Valoraciones/>}/>
                    <Route path='/salir' element={<Salir/>}/>
                    <Route path='/gps' element={<Salir/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;