import React from "react";
import {IPedido} from "../App";
import {Row, Col,} from "react-bootstrap";
import {Button} from "primereact/button";


interface IProps {
    pedido_:  IPedido
    setPedido:  React.Dispatch<React.SetStateAction<IPedido[]>>
}


const PedidoComponente: React.FC<IProps> = ({ pedido_, setPedido }) => {
   
    const deletePedido = () => {
        const options = { method: 'DELETE' }

        fetch("http://localhost:8080/pedido/"+ pedido_.id, options)
            .then(response => {
                if (response.ok) {
                    setPedido(prevState => prevState.filter(item => item.id !== pedido_.id))
                }
            })
            .catch(error => {
                console.log(error)
                alert("No se elimina")
            })
    }

    return (
        <Row>

            <Col md={8}>
                <span>{pedido_.id}</span>
            </Col>
            
            <Col md={2}>
                <Button onClick={deletePedido}>X</Button>
            </Col>
        </Row>
    )
}

export default PedidoComponente;