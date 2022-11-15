import React from "react";
import {IRestaurante} from "../../App";
import {Row, Col,} from "react-bootstrap";
import {Button} from "primereact/button";


interface IProps {
    restaurante_:  IRestaurante
    setRestaurante:  React.Dispatch<React.SetStateAction<IRestaurante[]>>
}
 

const RestauranteComponente: React.FC<IProps> = ({ restaurante_, setRestaurante }) => {
   
    // const deleteRestaurante = () => {
    //     const options = { method: 'DELETE' }

    //     fetch("http://localhost:8080/pedido/"+ pedido_.id, options)
    //         .then(response => {
    //             if (response.ok) {
    //                 setPedido(prevState => prevState.filter(item => item.id !== pedido_.id))
    //             }
    //         })
    //         .catch(error => {
    //             console.log(error)
    //             alert("No se elimina")
    //         })
    // }

    return (
        <Row>

            <Col md={8}>
                <span>{restaurante_.nombre}</span>
            </Col>
            
            {/* <Col md={2}>
                <Button onClick={deletePedido}>X</Button>
            </Col> */}
        </Row>
    )
}

export default RestauranteComponente;