import React, { useState , useEffect} from 'react';
import { ListBox, ListBoxChangeParams } from 'primereact/listbox';
import { IRestaurante } from '../../App';
import { RestauranteService } from '../../service/RestaurantesServices';

interface IProps {
    restaurante: IRestaurante[]
    setRestaurante: React.Dispatch<React.SetStateAction<IRestaurante[]>>
}
const ListaRestaurantes: React.FC<IProps> = ({restaurante, setRestaurante}) => {

    const rr: IRestaurante={
        nombre: '',
        razon: '',
        cif: '',
        direccion: '',
        tlf: '',
        categoria: ''
    }; 

    const [selectedRestaurantes, setSelectedRestaurantes] = useState(rr);

    const restauranteService = new RestauranteService();

    


    

    useEffect(() => {
        restauranteService.getRestaurantes().then(restaurante_ => setRestaurante(restaurante_));
    }, []); 
    

    const countryTemplate = (restaurante: IRestaurante) => {
        return (
            <div className="restaurante-item">
                
                <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>
                <div>{restaurante.nombre}</div>

            </div>
        );
    }



      function seleccionRestaurante(selectedRestaurantes: IRestaurante){


        
        
        console.log(selectedRestaurantes.nombre);

      }



      

    return (
        <div className="card">
            
            <ListBox value={selectedRestaurantes}   options={restaurante} onClickCapture={(e)=>seleccionRestaurante(selectedRestaurantes)}  onChange={(e) => setSelectedRestaurantes(e.value)} filter optionLabel="nombre"
                itemTemplate={countryTemplate} style={{ width: '95em' }} listStyle={{ maxHeight: '600px' }}  />

            
        </div>
    );
}

export default ListaRestaurantes;
