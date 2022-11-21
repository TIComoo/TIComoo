import React, { useState } from 'react';
import { Menubar } from 'primereact/menubar';
import Restaurante from '../../components/Restaurantes/ListaRestaurantes';
import Carta from '../../components/Carta/CartaComponente';
import Pagar from '../../components/Pedidos/PagarPedido';
import { BrowserRouter, Route, Routes } from 'react-router-dom';


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
  
export interface IPedido {
    id: any
    platos : []
    precio: number
    estado : string
}


const Menu = () => {


    
    const items = [
        {
            label: 'Restaurantes',
            icon: 'pi pi-fw pi-home',
            command:()=>{ }
            
             
        },
        {
            label: 'Novedades',
            icon: 'pi pi-fw pi-bolt',
            command:()=>{ window.location.href="http://localhost:8080/cliente/signup"; }
        },
        {
            label: 'Historial Pedidos',
            icon: 'pi pi-fw pi-book',
            command:()=>{ window.location.href="http://localhost:8080/cliente/signup"; }
        },
        {
            label: 'Configuración',
            icon: 'pi pi-fw pi-wrench',
            command:()=>{ window.location.href="http://localhost:8080/cliente/signup"; }
        },
        {
            label: 'Salir',
            icon: 'pi pi-fw pi-power-off',
        }
    ];

    const start = <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>;
    const [restaurante, setRestaurante] = useState<IRestaurante[]>([])
    const [carta, setCarta] = useState<ICarta[]>([]) 
    const [platos, setPlatos] = useState<IPlato[]>([])   
    const [pedidos, setPedidos] = useState<IPedido[]>([])
 

    return (
        <div>
            <div className="card">
            <div className="pt-2 pb-4">
            <BrowserRouter>
                <Routes>
                <Route path='/restaurante' element={<Restaurante restaurante={restaurante} setRestaurante={setRestaurante} carta={carta} setCarta={setCarta} />}/>
                    <Route path='/carta' element={<Carta platos={platos} setPlatos={setPlatos} carta={carta} setCarta={setCarta}/>}/>
                    <Route path='/pagar' element={<Pagar pedidos={pedidos} setPedidos={setPedidos}/>}/>
                    </Routes>
                    </BrowserRouter>  
                </div>
                <Menubar model={items} start={start} />
            </div>
        </div>
    );
}

export default Menu;