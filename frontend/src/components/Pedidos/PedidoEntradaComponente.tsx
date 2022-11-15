import React, {DetailedHTMLProps, InputHTMLAttributes, useState} from "react";
import {IPedido} from "../../App";
import {Col, Row} from "react-bootstrap";
import {Button} from "primereact/button";



interface IProps {
    setPedido: React.Dispatch<React.SetStateAction<IPedido[]>>
}


const PedidoEntradaComponente: React.FC<IProps> = ({setPedido}) => {
    const [newPedidoInput, setNewPedidoInput] = useState<string>("")

    const handleKeyPress = (event: DetailedHTMLProps<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>) => {
        if (event.key === 'Enter') {
            addPedido()
            setNewPedidoInput('')
        }
    }

    const addPedido = () => {
        const options = {
            method: 'POST',
            body: newPedidoInput,
        }

        fetch("http://localhost:8080/pedido/crearPedido", options)
            .then(response => response.json())
            .then(newPedido => setPedido(prevState => [...prevState, newPedido]))
            .catch(error => {
                console.log(error)
                alert("No se puede añadir el Pedido")
            })
    }

    return (
        <Row className={"añadir pedido"}>
            <Col md={10}>
                <input
                    className={"w-100"}
                    type="text"
                    placeholder={"Nuevo Pedido"}
                    value={newPedidoInput}
                    onChange={event => setNewPedidoInput(event.target.value)}
                    onKeyPress={handleKeyPress}
                />
            </Col>
            <Col md={2}>
                <Button onClick={addPedido}>Añadir Pedido</Button>
            </Col>
        </Row>
    )
}

export default PedidoEntradaComponente;