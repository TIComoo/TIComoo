import React, { useState } from 'react';
import { Menubar } from 'primereact/menubar';


const Menu = () => {


    
    const items = [
        {
            label: 'Restaurantes',
            icon: 'pi pi-fw pi-home',
            command:()=> { window.location.href='/restaurante'}
            
             
        },
        {
            label: 'Novedades',
            icon: 'pi pi-fw pi-bolt',
            command:()=>{ window.location.href="/novedades"; }
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
            command:()=>{ window.location.href="/salir"; }
        }
    ];

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