import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { PedidoService } from '../../service/PedidoService';
import { Button } from 'primereact/button';
import { IPedido} from '../Pedidos/Menu';
import { Row } from 'react-bootstrap';
const email="andres@gmail.com";
interface IProps {
    pedidos: IPedido[]
    setPedidos: React.Dispatch<React.SetStateAction<IPedido[]>>
}

const m="email";
const jso="{"+m+": "+JSON.stringify(email)+"}";
const PagarPedido: React.FC<IProps> = ({pedidos,setPedidos}) =>{

    const pedidoService = new PedidoService();

    useEffect(() => {

        const fechDatos = async () =>{
            const datos= await pedidoService.getPedidosEmail(jso);
            const json = await datos.json();

            setPedidos(json);

        }

        const resultado =  fechDatos().catch(console.error);

    }, []); // eslint-disable-line react-hooks/exhaustive-deps


    console.log(pedidos);

    

    return (
        <div>
            <div className="card">
                <DataTable value={pedidos} responsiveLayout="scroll">
                    <Column field="id" header="id"></Column>
                    <Column field="nombreRestaurante" header="Restaurante"></Column>
                    <Column field="fecha" header="Fecha"></Column>
                    <Column field={"0"} header="Total Platos"></Column>
                    <Column field="precio" header="Precio (€)"></Column>
                </DataTable>  
            </div>

        </div>
    );
}

export default PagarPedido;


