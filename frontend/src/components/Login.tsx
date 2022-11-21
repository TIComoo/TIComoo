import React, { useEffect, useState } from 'react';
import MenuRider from './Rider/RiderNavBar';
import {
  Formik,
  FormikHelpers,
  FormikProps,
  Form,
  Field,
  FieldProps,
  FormikTouched,
  FormikErrors,
} from 'formik';

interface IRider {
  email: string;
  nombre: string;
  apellido: string;
  pwd: string;
  nif: string;
  tipoVehiculo: string;
  matricula: string;
  carnet: string;
  activado: boolean;
  valoraciones: any;

}
interface ICliente {
  email: string;
  nombre: string;
  apellido: string;
  direccion: string;
  telefono: string;
  pwd: string;
  nif: string;
  confirmarPwd: string;
  activado: boolean;



}

import { useFormik } from 'formik';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { Calendar } from 'primereact/calendar';
import { Password } from 'primereact/password';
import { Checkbox } from 'primereact/checkbox';
import { Dialog } from 'primereact/dialog';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils';

import './FormDemo.css';
import { RiderService } from '../service/RiderService';
import { ClienteService } from '../service/ClienteService';

export const Login = () => {
  const [rider, setRider] = useState<IRider>();
  const [cliente, setCliente] = useState<ICliente>();
  const [showMessage, setShowMessage] = useState(false);
  const [formData, setFormData] = useState({});
  const riderService = new RiderService();
  const clienteService = new ClienteService();
  useEffect(() => {
   

    }, []); // eslint-disable-line react-hooks/exhaustive-deps

  const formik = useFormik({
    initialValues: {

      email: '',
      password: '',

    },
    validate: (data) => {
      const errors: any = {};



      if (!data.email) {
        errors.email = 'Email is required.';
      }
      else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(data.email)) {
        errors.email = 'Invalid email address. E.g. example@email.com';
      }

      if (!data.password) {
        errors.password = 'Password is required.';
      }


      return errors;
    },
    onSubmit: (data) => {
      setFormData(data);
      setShowMessage(true);

      formik.resetForm();
    }
  });
   
     // const isFormFieldValid = (name) => !!(formik.touched[name] && formik.errors[name]);
     /*  const getFormErrorMessage = (name) => {
          return isFormFieldValid(name) && <small className="p-error">{formik.errors[name]}</small>;
      };  */

  const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;
  const passwordHeader = <h6>Pick a password</h6>;
  const passwordFooter = (
    <React.Fragment>
      <Divider />
      <p className="mt-2">Suggestions</p>
      <ul className="pl-2 ml-2 mt-0" style={{ lineHeight: '1.5' }}>
        <li>At least one lowercase</li>
        <li>At least one uppercase</li>
        <li>At least one numeric</li>
        <li>Minimum 8 characters</li>
      </ul>
    </React.Fragment>
  );

 /*  function isFormFieldValid(arg0: string) {
    throw new Error('Function not implemented.');
  }

  function getFormErrorMessage(arg0: string): React.ReactNode {
    throw new Error('Function not implemented.');
  }
 */
  return (
    <div className = "App" >
    <div className="form-demo">
      <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '30vw' }}>
        <div className="flex align-items-center flex-column pt-6 px-3">
          <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
          <h5>Usuario loggeado correctamente.</h5>
          
        </div>
      </Dialog>

      <div className="flex justify-content-center">
        <div className="card">
          <h5 className="text-center">Register</h5>
          <form onSubmit={formik.handleSubmit} className="p-fluid">
            
            <div className="field">
              <span className="p-float-label p-input-icon-right">
                <i className="pi pi-envelope" />
                <InputText id="email" name="email" value={formik.values.email} onChange={formik.handleChange} className={classNames()} />
                <label htmlFor="email" className={classNames()}>Email*</label>
              </span>
              
            </div>
            <div className="field">
              <span className="p-float-label">
                <Password id="password" name="password" value={formik.values.password} onChange={formik.handleChange} toggleMask
                  className={classNames()} header={passwordHeader} footer={passwordFooter} />
                <label htmlFor="password" >Password*</label>
              </span>
              
            </div>
            
           {/*  <div className="field-checkbox">
              <Checkbox inputId="accept" name="accept" checked={formik.values.accept} onChange={formik.handleChange} className={classNames({ 'p-invalid': isFormFieldValid('accept') })} />
              <label htmlFor="accept" className={classNames({ 'p-error': isFormFieldValid('accept') })}>I agree to the terms and conditions*</label>
            </div> */}

            <Button type="submit" label="Submit" className="mt-2" />
          </form>
        </div>
      </div>
    </div>
    </div>
  );
}
export default Login;