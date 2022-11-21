import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { PedidoService } from '../../service/PedidoService';
import { Button } from 'primereact/button';
import { IPedido, IPlato } from '../../App';
import { Row } from 'react-bootstrap';

interface IProps {
    pedidos: IPedido[]
    setPedidos: React.Dispatch<React.SetStateAction<IPedido[]>>
}
const PagarPedido: React.FC<IProps> = ({pedidos,setPedidos}) =>{

    const pedidoService = new PedidoService();

    useEffect(() => {

        const fechDatos = async () =>{
            const datos= await pedidoService.getIdMasAlto();
            const json = await datos.json();

            setPedidos(json);

        }

        const resultado =  fechDatos().catch(console.error);

    }, []); // eslint-disable-line react-hooks/exhaustive-deps

    let cont =0;
    const listaPlatos:IPlato[]=[];
    if(pedidos.length==1 && cont ==0){
        const rellenar=rellenarPlatos(pedidos.at(0)?.platos);
        cont=1;
        
    }

    function rellenarPlatos(datos: any){
        let size:any;
        size=0;
        size=pedidos.at(0)?.platos.length;

        for(let i=0; i<size;i++){
            datos=pedidos.at(0)?.platos.at(i);
            listaPlatos.push(datos);
        }
    }

    function handleClick(e: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        console.log('this is:', e);
      }
    

    const row: any=-1;
    const actionBodyTemplate = (row: any) => {
        row++;
        return <Button  type="button" icon="pi pi-times-circle" tabIndex={row} onClick={(e)=> handleClick(e)}></Button>;

    }
    return (
        <div>
            <div className="card">
                <DataTable value={listaPlatos} responsiveLayout="scroll">
                    <Column field="id" header="id"></Column>
                    <Column field="nombre" header="Nombre"></Column>
                    <Column field="precio" header="Precio"></Column>
                    <Column headerStyle={{ width: '4rem', textAlign: 'center' }} bodyStyle={{ textAlign: 'center', overflow: 'visible' }} body={actionBodyTemplate} />    
                </DataTable>  
            </div>
            <br></br>
            <br></br>
            <div>

                <Button>Pagar pedido</Button>
            </div>
        </div>
    );
}

export default PagarPedido;

function handleClick() {
    throw new Error('Function not implemented.');
}
