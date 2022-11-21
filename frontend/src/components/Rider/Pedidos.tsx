import React, { useState, useEffect, useRef } from "react";
import { RiderService } from '../../service/RiderService'
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";
import { DataTable, DataTableSelectParams } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { event } from "jquery";
import { Toast } from 'primereact/toast';




export interface IPedido {
    id?: any
    st_platos?: any,
    precio?: number,
    estado?: string,
    direccion?: string,
    nombreRestaurante?: any
}
export interface Pedido {
    id: any
    platos: string,
    precio: number,
    estado: string,
    fecha: string,
    direccion: string,
    nombreRestaurante: string
}
const Pedidos = () => {
    const [pedidos, setPedidos] = useState<IPedido[]>([]);
    const riderService = new RiderService();
    const [selectedPedido, setSelectedPedido] = useState(null);
    const toast = useRef<any>();

    useEffect(() => {

        riderService.getAll().then(data => {
            console.log(data)

            setPedidos(data)

        }
        )

            .catch(error => console.log(error));

    }, []);
    const onRowSelect = (event: DataTableSelectParams) => {
        toast.current?.show({ severity: 'info', summary: 'Pedido Seleccionado', detail: `${event.data.st_platos}`, life: 3000 });
    }
   /*  const onRowUnselect = (event: any) => {
        toast.current.show({ severity: 'warn', summary: 'Pr Unselected', detail: `Name: ${event.data.name}`, life: 3000 });
    } */
    /*   const onRowSelect = (event) => {
            toast.current.show({ severity: 'info', summary: 'Product Selected', detail: `Name: ${event.data.name}`, life: 3000 });
        }
        const on
        const onRowUnselect = (event) => {
            toast.current.show({ severity: 'warn', summary: 'Product Unselected', detail: `Name: ${event.data.name}`, life: 3000 });
        } */


    return (
        <div>
            <Toast ref={toast} />
            <div className="card">
                <DataTable value={pedidos} responsiveLayout="scroll" selectionMode="single" selection={selectedPedido} onSelectionChange={e => setSelectedPedido(e.value)}
                    onRowSelect={onRowSelect}  >
                    {/*  <Column field="id" header="id"></Column> */}
                    <Column field="nombreRestaurante" header="Restaurante"></Column>
                    <Column field="st_platos" header="Platos del pedido"></Column>
                    <Column field="precio" header="Precio(euros)"></Column>
                    <Column field="fecha" header="Fecha"></Column>
                    <Column field="estado" header="Estado"></Column> 
                    <Column field="direccion" header="Direccion"></Column>
                </DataTable>
            </div>

        </div>
    )
    /*  <div className="card">
                    <h5>Events</h5>
    
                    <h6>Row Selection</h6>
                    <p>onRowSelect and onRowUnselects are available as selection events.</p>
                    <DataTable value={products} selectionMode="single" selection={selectedProduct3} onSelectionChange={e => setSelectedProduct3(e.value)} dataKey="id" responsiveLayout="scroll"
                        onRowSelect={onRowSelect} onRowUnselect={onRowUnselect}>
                        <Column field="code" header="Code"></Column>
                        <Column field="name" header="Name"></Column>
                        <Column field="category" header="Category"></Column>
                        <Column field="quantity" header="Quantity"></Column>
                    </DataTable> */
}

export default Pedidos;