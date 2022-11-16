import React from "react";
import {IPedido} from "../../App";
import {Row, Col,} from "react-bootstrap";
import {Button} from "primereact/button";

interface IProps{
    pedido_: IPedido
    setPedido: React.Dispatch<React.SetStateAction<IPedido>>
}

const PedidoComponente: React.FC<IProps> =({pedido_, setPedido}) => {
    
    const seleccionarPedidoDisponible = () => {

        
    }


    return (
        <Row>

            <Col md={8}>
                <span>{pedido_.id}</span>
            </Col>
            
            <Col md={2}>
                <Button onClick={seleccionarPedidoDisponible}>X</Button>
            </Col>
        </Row>
    )

    }


export default PedidoComponente;