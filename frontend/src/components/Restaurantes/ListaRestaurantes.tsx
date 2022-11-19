import React, { useState , useEffect} from 'react';
import { ListBox } from 'primereact/listbox';
import { ICarta, IRestaurante } from '../../App';
import { RestauranteService } from '../../service/RestauranteService';
import {CartaService} from '../../service/CartaService';
import CartaComponente from '../Carta/CartaComponente';


// export let cartaElegida: any;


// export function* cambiarC(aux:any) {
//     cartaElegida=aux;
// }
// export function getElegida() {
//     return cartaElegida;
// }


interface IProps {
    restaurante: IRestaurante[]
    setRestaurante: React.Dispatch<React.SetStateAction<IRestaurante[]>>
    carta: ICarta[]
    setCarta: React.Dispatch<React.SetStateAction<ICarta[]>>

}


const ListaRestaurantes: React.FC<IProps> = ({carta, setRestaurante, restaurante, setCarta}) => {
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

    const cartaService = new CartaService();
    
    useEffect(() => {
        const serv=()=>{

            cartaService.getCartas().then(carta_ => setCarta(carta_));
            restauranteService.getRestaurantes().then(restaurante_ => setRestaurante(restaurante_));
    };
    serv();
    }, []); 

    const countryTemplate = (restaurante: IRestaurante) => {
        return (
            <div className="restaurante-item">
                
                <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>
                <div>{restaurante.nombre}</div>

            </div>
        );
    }



      function seleccionRestaurante(selectedRestaurantes: IRestaurante, carta: ICarta[]){
        for(let i=0;i<carta.length;i++){

            console.log(selectedRestaurantes.nombre+" AQUI");
            if( selectedRestaurantes.nombre == carta.at(i)?.nombreRestaurante ){
                cartaService.enviarEleccion(selectedRestaurantes.nombre);
                window.location.href='/carta';

            }
  
        }
        
      }


      

    return (
        <div className="card">
            
            <ListBox value={selectedRestaurantes}   options={restaurante}  onDoubleClick={(e)=>seleccionRestaurante(selectedRestaurantes, carta)}  onChange={(e) => setSelectedRestaurantes(e.value)} filter optionLabel="nombre"
                itemTemplate={countryTemplate} style={{ width: '95em' }} listStyle={{ maxHeight: '600px' }}  />

            
        </div>
    );
}

export default ListaRestaurantes;


