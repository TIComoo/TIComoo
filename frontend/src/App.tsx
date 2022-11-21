import React, {useEffect, useState} from 'react';


import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import Menu from './components/Menu';
import CartaComponente from './components/Carta/CartaComponente';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Restaurante from './components/Restaurantes/ListaRestaurantes';
// import Historial from './components/Rider/Historial';
import Carta from './components/Carta/CartaComponente';
import Pagar from './components/Pedidos/PagarPedido'
// import Valoraciones from './components/Rider/Valoraciones';
// import Salir from './components/Rider/Salir';




export interface IPedido {
    includes(val: IPedido): unknown;
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
            <Menu/>
            <BrowserRouter>
                <Routes>
                    <Route path='/restaurante' element={<Restaurante restaurante={restaurante} setRestaurante={setRestaurante} carta={carta} setCarta={setCarta} />}/>
                    <Route path='/carta' element={<Carta platos={platos} setPlatos={setPlatos} carta={carta} setCarta={setCarta}/>}/>
                    <Route path='/pagar' element={<Pagar pedidos={pedidos} setPedidos={setPedidos}/>}/>
                    {/* <Route path='/valoraciones' element={<Valoraciones/>}/>
                    <Route path='/salir' element={<Salir/>}/> */}
                     
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;