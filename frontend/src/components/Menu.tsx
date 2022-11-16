import React, { useState } from 'react';
import { Menubar } from 'primereact/menubar';
import ListaRestaurantes from './Restaurantes/ListaRestaurantes';
import { render } from '@testing-library/react';

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

interface IProps {
    restaurante: IRestaurante[]
    setRestaurante: React.Dispatch<React.SetStateAction<IRestaurante[]>>
}

const Menu: React.FC<IProps> = ({restaurante, setRestaurante}) =>{


    
    const items = [
        {
            label: 'Restaurantes',
            icon: 'pi pi-fw pi-home',
            command:() =>  restaurantesClick()
            
             
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

    const restaurantesClick: () => any(){
        
            return{
                <ListaRestaurantes restaurante={restaurante } setRestaurante={setRestaurante} ></ListaRestaurantes>
            }
        
    }
    const start = <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>;

    return (
        <div>
            <div className="card">
            <div className="pt-2 pb-4">
                    
                </div>
                <Menubar model={items} start={start} />
            </div>
        </div>
    );
}

export default Menu;