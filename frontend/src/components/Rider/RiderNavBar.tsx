import { Menubar } from 'primereact/menubar';
import React, { useState } from 'react';

const Navigation = () => {
    const navlist = [
        { label: 'Pedidos Disponibles', icon: 'pi pi-fw pi-home' },
        { label: 'Historial de Pedidos', icon: 'pi pi-fw pi-file' },
        { label: 'Cuenta', icon: 'pi pi-fw pi-user' },
        {label: 'Mis Valoraciones' ,icon: 'pi pi-fw pi-thumbs-up-fill'},
        { label: 'Salir' ,icon: 'pi pi-fw pi-power-off'}
         
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