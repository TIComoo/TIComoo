import React from "react";
import {IPedido} from "../App";
import {Container} from "react-bootstrap";
import PedidoComponente from "./PedidoComponente";


interface IProps {
    pedido: IPedido[]
    setPedido: React.Dispatch<React.SetStateAction<IPedido[]>>
}

 
const PedidoListaComponente: React.FC<IProps> = ({pedido, setPedido}) => {
    return (
        <Container>
            <hr/>
            <h2 className={"display-4"}>Pedido</h2>
            {
                pedido.map(pedido_ => <PedidoComponente setPedido={setPedido} pedido_={pedido_}/>)
            }
        </Container>
        
    )
}

export default PedidoListaComponente;