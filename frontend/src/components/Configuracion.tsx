
import React, { useEffect, useState } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Password } from 'primereact/password';
import { Checkbox } from 'primereact/checkbox';
import { Dialog } from 'primereact/dialog';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils';
import { ClienteService } from '../service/ClienteService';
import './FormDemo.css';
import { ICliente } from './Pedidos/Menu';

interface IProps {
    clientes: ICliente
    setClientes: React.Dispatch<React.SetStateAction<ICliente>>
}

const email="andres@gmail.com";

const m="email";
const jso="{"+m+": "+JSON.stringify(email)+"}";

const Configuracion:  React.FC<IProps> = ({clientes,setClientes}) => {
    
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData] = useState({});
    const clienteService = new ClienteService();
    const defaultValues = {
        telefono: '',
        direccion:"",
        pwd:"",
        accept: false
    }

    useEffect(() => {
        const fechDatos = async () =>{
            const datos= await clienteService.getClienteEmail(jso);
            const json = await datos.json();

            setClientes(json);

        }

        const resultado =  fechDatos().catch(console.error);
    }, []); // eslint-disable-line react-hooks/exhaustive-deps

    console.log(clientes);
    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });

    const onSubmit: any = (data: any) => {
        setFormData(data);
        setShowMessage(true);

        reset();
    };

    function cambiarDatos(){
        console.log("CLICK")
        console.log(formData);
        console.log(showMessage);
    }

    const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;
    const passwordHeader = <h6>Tu contraseña</h6>;
    const passwordFooter = (
        <React.Fragment>
            <Divider />
            <p className="mt-2">Sugerencias</p>
            <ul className="pl-2 ml-2 mt-0" style={{ lineHeight: '1.5' }}>
                <li>Como minimo una letra minuscula</li>
                <li>Como minimo una letra mayuscula</li>
                <li>Como minimo un número</li>
                <li>Minimo 8 caracteres</li>
            </ul>
        </React.Fragment>
    );

    return (
        <div className="form-demo">
            <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '30vw' }}>
                <div className="flex justify-content-center flex-column pt-6 px-3">
                    <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
                    
                </div>
            </Dialog>

            <div className="flex justify-content-center">
                <div className="card">
                    <h5 className="text-center">CONFIGURACION</h5>
                    <form onSubmit={()=>handleSubmit(onSubmit)} className="p-fluid">
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="telefono" control={control} rules={{ required: 'Name is required.' }} render={({ field, fieldState }) => (
                                    <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })}/>
                                )} />
                                <label htmlFor="telefono" className={classNames({ 'p-error': errors.telefono })}>Telefono nuevo...</label>
                            </span>
                        </div>
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="direccion" control={control} rules={{ required: 'Name is required.' }} render={({ field, fieldState }) => (
                                    <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })}/>
                                )} />
                                <label htmlFor="direccion" className={classNames({ 'p-error': errors.direccion })}>Direccion nueva...</label>
                            </span>
                        </div>
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="pwd" control={control} rules={{ required: 'Password is required.' }} render={({ field, fieldState }) => (
                                    <Password id={field.name} {...field} toggleMask className={classNames({ 'p-invalid': fieldState.invalid })} header={passwordHeader} footer={passwordFooter} />
                                )} />
                                <label htmlFor="pwd" className={classNames({ 'p-error': errors.pwd })}>Contraseña nueva...</label>
                            </span>
                        </div>
                        <div className="field-checkbox">
                            <Controller name="accept" control={control} rules={{ required: true }} render={({ field, fieldState }) => (
                                <Checkbox inputId={field.name} onChange={(e) => field.onChange(e.checked)} checked={field.value}  />
                            )} />
                            <label htmlFor="accept" className={classNames({ 'p-error': errors.accept })}>Acepto cambiar mis datos...</label>
                        </div>
                        <br></br>
                        <br></br>
                        <Button type="submit" label="Cambiar" onClick={()=> cambiarDatos()} className="mt-2" />
                    </form>
                </div>
            </div>
        </div>
    );
}
             
export default Configuracion;