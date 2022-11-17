import React, { useState, useEffect } from "react";
import { RiderService } from '../../service/RiderService'
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

export interface IPedido {
    id: any
     platos: any,
    precio: number,
    estado: string
} 

const Pedidos = () => {
    const [pedidos, setPedidos] = useState<IPedido[]>([]);
    const riderService = new RiderService();

    useEffect(() => {
        riderService.getAll().then(data => {
            //console.log(data)

            setPedidos(data)

        }
        )

            .catch(error => console.log(error));

    }, []);



    return (
        <div>
            <div className="card">
                <DataTable value={pedidos} responsiveLayout="scroll">
                   {/*  <Column field="id" header="id"></Column> */}
                    <Column field="st_platos" header="platos"></Column>
                    <Column field="precio" header="precio"></Column>
                    <Column field="fecha" header="fecha"></Column>
                   {/*  <Column field="estado" header="estado"></Column> */}
                    
                </DataTable>
            </div>
        </div>
    )

}

export default Pedidos;