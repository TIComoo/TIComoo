import React, { useState, useEffect } from 'react';
import { DataScroller } from 'primereact/datascroller';
import { Button } from 'primereact/button';
import { PlatoService } from '../../service/PlatoService';
import './CartaComponente.css';
import { ICarta, IPlato, IRestaurante } from '../../App';
import { json } from 'stream/consumers';
import useTimeout from '../useTimeout';
import CartaService from '../../service/CartaService';

interface IProps {
    platos: IPlato[]
    setPlatos: React.Dispatch<React.SetStateAction<IPlato[]>>
    carta: ICarta[]
    setCarta: React.Dispatch<React.SetStateAction<ICarta[]>>
}

const CartaComponente: React.FC<IProps> = ({platos, setPlatos, carta, setCarta}) => {


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

        console.log(platos);

        const resultado = fechDatos().catch(console.error);

    }, []); // eslint-disable-line react-hooks/exhaustive-deps

    const cartaElegida=carta.at(0)?.cartaElegida;


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
                    <Button icon="pi pi-shopping-cart" label="Añadir a la cesta" ></Button>
                </div>
            </div>
        );
    }


    return (
        <div className="cartacomponente">
            <div className="card">
                <DataScroller value={platos} itemTemplate={itemTemplate} rows={5} inline scrollHeight="500px" header={cartaElegida} />
            </div>
        </div>
    );
}

export default CartaComponente;


