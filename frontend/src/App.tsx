import React, { useEffect, useState } from 'react';




import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import Pedidos from './components/Rider/Pedidos';
import Historial from './components/Rider/Historial';
import Cuenta from './components/Rider/Cuenta';
import Valoraciones from './components/Rider/Valoraciones';
import Salir from './components/Rider/Salir';

import Restaurante from './components/Restaurantes/ListaRestaurantes';
import Carta from './components/Carta/CartaComponente';
import Pagar from './components/Pedidos/PagarPedido';
import { BrowserRouter, Route, Routes } from 'react-router-dom';


import MenuRider from './components/Rider/RiderNavBar';
import { Menubar } from 'primereact/menubar';

export interface IPedido {
    id: any
    platos: []
    precio: number
    estado: string
}

export interface IRestaurante {

    nombre: string
    razon: string
    cif: string
    direccion: string
    tlf: string
    categoria: string
}

export interface ICarta {
    id: any
    nombreRestaurante: string
    cartaElegida: string
}

export interface IPlato {

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
             <MenuRider></MenuRider>
                    
           
                <Routes>
                    <Route path= "/" element = {null}></Route>
                    <Route path='/rider/pedidos' element={<Pedidos />} />
                    {/* <Route path='/historial' element={<Historial />} /> */}
                    <Route path='/cuenta' element={<Cuenta />} />
                    <Route path='/valoraciones/' element={<Valoraciones />} />
                    <Route path='/salir' element={<Salir />} />
                    <Route path='/gps' element={<Salir />} />

                </Routes>
         
        </div>
    );
}

export default App;