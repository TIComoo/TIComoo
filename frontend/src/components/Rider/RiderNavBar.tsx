import { Menubar } from 'primereact/menubar';
import React, { useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Pedidos from '../../components/Rider/Pedidos';
import Historial from '../../components/Rider/Historial';
// import Cuenta from '../../components/Rider/Cuenta';
import Valoraciones from '../../components/Rider/Valoraciones';
import Salir from '../../components/Rider/Salir';

const Navigation = () => {
    const navlist = [
        { label: 'Pedidos Disponibles', icon: 'pi pi-fw pi-home', command: () => { window.location.href='/pedidos'}},
        { label: 'Pedido pendiente', icon: 'pi pi-fw pi-file', command: () => { window.location.href='/historial'} },
        { label: 'Cuenta', icon: 'pi pi-fw pi-user', command: () => { window.location.href='/cuenta'}},
        { label: 'GPS', icon: 'pi pi-fw pi-map-marker', command: () => { window.location.href='/gps'}},
        { label: 'Mis Valoraciones' ,icon: 'pi pi-fw pi-thumbs-up-fill', command: () => { window.location.href='/valoraciones'}},
        { label: 'Salir' ,icon: 'pi pi-fw pi-power-off', command: () => { window.location.href='/salir'}}
         
    ];
    let email = "sergio@gmail.com";
    return (
        <div>
            <header>
            <BrowserRouter>
                <Routes>
                    <Route path='/pedidos' element={<Pedidos/>}/>
                    <Route path='/historial' element={<Historial/>}/>
                    {/* <Route path='/cuenta/:email' element={<Cuenta/>}/> */}
                    <Route path='/valoraciones/{}' element={<Valoraciones/>}/>
                    <Route path='/salir' element={<Salir/>}/>
                    <Route path='/gps' element={<Salir/>}/>
                </Routes>
            </BrowserRouter>
                <nav>
                    <ul>
                        <Menubar model={navlist}/>
                    </ul>
                </nav>
            </header>
        </div>
    )
}
/*  */
export default Navigation;