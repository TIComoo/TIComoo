import { Menubar } from 'primereact/menubar';
import React, { useState } from 'react';

const Navigation = () => {
    const navlist = [
        { label: 'Pedidos Disponibles', icon: 'pi pi-fw pi-home', command: () => { window.location.href='/pedidos'}},
        { label: 'Pedido pendiente', icon: 'pi pi-fw pi-file', command: () => { window.location.href='/historial'} },
        { label: 'Cuenta', icon: 'pi pi-fw pi-user', command: () => { window.location.href='/cuenta'}},
        { label: 'GPS', icon: 'pi pi-fw pi-map-marker', command: () => { window.location.href='/gps'}},
        { label: 'Mis Valoraciones' ,icon: 'pi pi-fw pi-thumbs-up-fill', command: () => { window.location.href='/valoraciones'}},
        { label: 'Salir' ,icon: 'pi pi-fw pi-power-off', command: () => { window.location.href='/salir'}}
         
    ];

    return (
        <div>
            <header>
                <nav>
                    <ul>
                        <Menubar
                            model={navlist}
                        />
                    </ul>
                </nav>
            </header>
        </div>
    )
}
export default Navigation;