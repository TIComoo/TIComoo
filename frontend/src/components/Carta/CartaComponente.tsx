import React, { useState, useEffect } from 'react';
import { DataScroller } from 'primereact/datascroller';
import { Button } from 'primereact/button';
import { PlatoService } from '../../service/PlatoService';
import './CartaComponente.css';
import { ICarta, IPlato, IRestaurante } from '../../App';
import CartaService from '../../service/CartaService';
import PedidoService from '../../service/PedidoService';

interface IProps {
    platos: IPlato[]
    setPlatos: React.Dispatch<React.SetStateAction<IPlato[]>>
    carta: ICarta[]
    setCarta: React.Dispatch<React.SetStateAction<ICarta[]>>
}
const pedidoService = new PedidoService();

const listaPlatos: IPlato[]=[];



export const id =pedidoService.getIdMasAlto();

const CartaComponente: React.FC<IProps> = ({platos, setPlatos, carta, setCarta}) => {

    console.log(id);
    const platoService = new PlatoService();

    const cartaService = new CartaService();

    


   
    useEffect(() => {


        const fechDatos = async () =>{
            const datos=await platoService.getPlatos();
            const json = await datos.json();

            setPlatos(json);

            const datosC=await cartaService.getCartaElegida();
            const jsonC=await datosC.json();


            setCarta(jsonC);
        }
        const resultado = fechDatos().catch(console.error);


    }, []); // eslint-disable-line react-hooks/exhaustive-deps

    const cartaElegida=carta.at(0)?.cartaElegida;
    
    const [contador,setContador]= useState(0);

    function añadirPlatos(plato: IPlato,listaPlatos: IPlato[]){
        listaPlatos.push(plato);
        setContador(contador+1);

    }

    function pagar(listaPlatos: IPlato[]){

        const p="platos";
        const json="{ "+p+":"+JSON.stringify(listaPlatos)+"}";
        window.location.href="/pagar";
        pedidoService.enviarEleccion(json);

    }

    const itemTemplate = (plato: IPlato) => {
        return (
            <div className="plato-item">
                <img src={plato.imagen} alt={plato.nombre} />
                <div className="plato-detail">
                    <div className="plato-name">{plato.nombre}</div>
                    <div className="plato-description">{plato.descripcion}</div>
                    {/* <Rating value={data.rating} readOnly cancel={false}></Rating> */}
                    <i className="pi pi-tag product-category-icon"></i><span className="plato-category">{plato.categoria}</span>
                </div>
                <div className="plato-action">
                    <span className="plato-price">{plato.precio}€</span>
                    <Button icon="pi pi-shopping-cart" label="Añadir a la cesta" onClick={(e)=> añadirPlatos(plato,listaPlatos)}></Button>
                    
                </div>
            </div>
        );
    }

    
    

    return (
        <div className="cartacomponente">
            <div className="card">
                <DataScroller value={platos} itemTemplate={itemTemplate} rows={5} inline scrollHeight="500px" header={cartaElegida} />
            </div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <div className="pagar">

            <Button icon="pi pi-shopping-cart" label="Cesta:" onClick={(e)=> pagar(listaPlatos)}>{contador}</Button>
            </div>
        </div>
    );
}

export default CartaComponente;




