import axios from "axios";
import React, { useEffect, useState } from "react";
import { RiderService } from "../../service/RiderService";
import { InputText } from 'primereact/inputtext';
import './FormDemo.css';
import { Dialog } from 'primereact/dialog';
import { Button } from "primereact/button";
import { Divider } from "primereact/divider";
import { useForm, Controller } from 'react-hook-form';
import { classNames } from 'primereact/utils';
import { Password } from "primereact/password";
import { render } from "react-dom";

export interface IRider {
  email: string;
  nif: string;
  carnet: string;
  tipoVehiculo: string;
  nombre: string;
  apellido: string;
  pwd: string;
  activado: boolean
}


const Cuenta  = () => {
  const [rider, setRider] = useState<IRider>();
  const riderService = new RiderService();
  const [showMessage, setShowMessage] = useState(false);
  const [formData, setFormData] = useState({});
  useEffect(() => {
    axios.get('http://localhost:8080/rider/leerRiderPorEmail',
      {
        headers: {
          email: "victoria@gmail.com"
        }
      }

    ).then(res => res.data).then(data => {

      console.log(data);
      setRider(data);
    })
  }, []);
  const defaultValues = {
    email: rider?.email,
    nif: rider?.nif,
    carnet: rider?.carnet,
    tipoVehiculo: rider?.tipoVehiculo,
    nombre: rider?.nombre,
    apellido: rider?.apellido,
    pwd: rider?.pwd,
    activado: true
  }

  /* const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });
 */
  /* const onSubmit = (data: React.SetStateAction<IRider | any>) => {
    setFormData(data);
    console.log(data);
    setShowMessage(true);

    reset();
  };
  const getFormErrorMessage = (name: any) => {
    /*  return errors[] && <small className="p-error">{errors[name].message}</small> 
  }; */

  return(
  <div>
    <div className= "card">
     <div>
     <span className="ml-2">Email</span>
    <InputText value={rider?.email} onChange={(e) => setRider(rider)}></InputText>
    <br />
     </div>
     <div>
    <span className="ml-2">Nombre</span>
    <InputText value={rider?.nombre} onChange={(e) => setRider(rider)}></InputText>
    <br />
    </div>
    <span className="ml-2">Apellido</span>
    <InputText value={rider?.apellido} onChange={(e) => setRider(rider)}></InputText>
    <br />
    <span className="ml-2">NIF</span>
    <InputText value={rider?.nif} onChange={(e) => setRider(rider)}></InputText>
    <br />
    <span className="ml-2">Carnet</span>
    <InputText value={rider?.carnet} onChange={(e) => setRider(rider)}></InputText>
    <br />
   
    <span className="ml-2">Tipo de Vehiculo </span>
    <InputText value={rider?.tipoVehiculo} onChange={(e) => setRider(rider)}></InputText>
    <br />
    <span className="ml-2">Contraseña </span>
    <Password value={rider?.pwd} onChange={(e) => setRider(rider)}></Password>
  
    </div>
    </div>
  )
}
export default Cuenta;
