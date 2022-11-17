import React, {useEffect, useState} from 'react';
import PedidoEntradaComponente from "./components/Pedidos/PedidoEntradaComponente";
import PedidoListaComponente from "./components/Pedidos/PedidoListaComponente";
import Container from 'react-bootstrap/Container';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import Menu from './components/Menu';
import MenuRider from './components/Rider/RiderNavBar'
import Pedidos from './components/Rider/Pedidos';
import Historial from './components/Rider/Historial';
import Cuenta from './components/Rider/Cuenta';
import Valoraciones from './components/Rider/Valoraciones';
import Salir from './components/Rider/Salir';

import ListaRestaurantes from './components/Restaurantes/ListaRestaurantes';
import { BrowserRouter, Route, Routes } from 'react-router-dom';



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
   
    return (
        <div className="App">
           {/*  <Menu></Menu>
           {<ListaRestaurantes setRestaurante={setRestaurante} restaurante={restaurante}/>} */}
            <MenuRider/>
            <BrowserRouter>
                <Routes>
                    <Route path='/pedidos' element={<Pedidos/>}/>
                    <Route path='/historial' element={<Historial/>}/>
                    <Route path='/cuenta' element={<Cuenta/>}/>
                    <Route path='/valoraciones' element={<Valoraciones/>}/>
                    <Route path='/salir' element={<Salir/>}/>
                    
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;