import React, { useEffect, useState } from "react";
import { IPedido } from "../../App";
import { Container } from "react-bootstrap";
import PedidoComponente from "./PedidoComponente";
import axios from 'axios'

interface IProps {
    pedido: IPedido[]
    setPedido: React.Dispatch<React.SetStateAction<IPedido[]>>
}

const baseURL = 'http://localhost:8080/';

function PedidoListaComponente() {
    const [data, setData] = useState();
    useEffect(() => {
        axios.get('pedido/todos')
            .then(res => {
                setData(res.data)
            })
            .catch(err => console.error(err));
    }

}



