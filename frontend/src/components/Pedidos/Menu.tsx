import React, { useState } from 'react';
import { Menubar } from 'primereact/menubar';
import Restaurante from '../../components/Restaurantes/ListaRestaurantes';
import Carta from '../../components/Carta/CartaComponente';
import Pagar from '../../components/Pedidos/PagarPedido';
import Historial from '../../components/Pedidos/HistorialPedidos';
//import Configuracion from '../Configuracion';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

export interface IPedido {
    id?: any
    platos: IPlato[],
    st_platos?: string,
    precio?: number,
    estado?: string,
    direccion?: string,
    nombreRestaurante?: any
    cliente:string
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

export interface IPlato{

    nombre: string
    nombreRestaurante: string
    categoria: string
    imagen: string
    descripcion: string
    precio: any
    aptoVeganos: string
}
export interface ICliente{
    
    email:string
    apellido:string
    pwd:string
    nif: string 
    direccion: string 
    telefono: string
}



const Menu = () => {


    
    const items = [
        {
            label: 'Restaurantes',
            icon: 'pi pi-fw pi-home',
            command:()=>{ window.location.href="/restaurante"; }
            
             
        },
        {
            label: 'Novedades',
            icon: 'pi pi-fw pi-bolt',
            command:()=>{ window.location.href="" }
        },
        {
            label: 'Historial Pedidos',
            icon: 'pi pi-fw pi-book',
            command:()=>{ window.location.href="/historial"; }
        },
        {
            label: 'Configuración',
            icon: 'pi pi-fw pi-wrench',
            command:()=>{ window.location.href="/configuracion"; }
        },
        {
            label: 'Salir',
            icon: 'pi pi-fw pi-power-off',
        }
    ];

    const start = <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>;

    const c:ICliente ={
    
        email:"",
        apellido:"",
        pwd:"",
        nif: "", 
        direccion: "", 
        telefono: ""
    };

    const [restaurante, setRestaurante] = useState<IRestaurante[]>([])
    const [carta, setCarta] = useState<ICarta[]>([]) 
    const [platos, setPlatos] = useState<IPlato[]>([])   
    const [pedidos, setPedidos] = useState<IPedido[]>([])
    const [clientes, setClientes] = useState<ICliente>(c)

 

    return (
        <div>
            <div className="card">
            <div className="pt-2 pb-4">
            <Menubar model={items} start={start} />
            <BrowserRouter>
                <Routes>
                <Route path='/restaurante' element={<Restaurante restaurante={restaurante} setRestaurante={setRestaurante} carta={carta} setCarta={setCarta} />}/>
                    <Route path='/carta' element={<Carta platos={platos} setPlatos={setPlatos} carta={carta} setCarta={setCarta}/>}/>
                    <Route path='/pagar' element={<Pagar pedidos={pedidos} setPedidos={setPedidos}/>}/>
                    <Route path='/historial' element={<Historial pedidos={pedidos} setPedidos={setPedidos}/>}/>
                   {/*  <Route path='/configuracion' element={<Configuracion clientes={clientes} setClientes={setClientes}/>}/>

 */}
                    </Routes>
                    </BrowserRouter>  
                </div>
                
            </div>
        </div>
    );
}

export default Menu;