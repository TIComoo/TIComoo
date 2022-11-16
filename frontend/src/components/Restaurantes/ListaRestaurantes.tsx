import React, { useState } from 'react';
import { ListBox } from 'primereact/listbox';
import { Button } from 'primereact/button';
import { IRestaurante } from '../../App';
import RestauranteComponente from "./RestauranteComponente";

interface IProps {
    restaurante: IRestaurante[]
    setRestaurante: React.Dispatch<React.SetStateAction<IRestaurante[]>>
}
const ListaRestaurantes: React.FC<IProps> = ({restaurante, setRestaurante}) => {


    const [selectedRestaurantes, setSelectedRestaurantes] = useState(null);


    

    // const restaurantes = [
    //     { name: 'McDonals', code: 'AU' },
    //     { name: 'KFC', code: 'BR' },
    //     { name: 'Burger King', code: 'CN' },
    //     { name: 'Sakura', code: 'EG' },
    //     { name: 'Pomodoro', code: 'FR' },
    //     { name: 'Diverxo', code: 'DE' },
    //     { name: 'Jsio', code: 'IN' },
    //     { name: 'Casa Pepe', code: 'JP' },
    //     { name: 'Kebab Lavapies', code: 'ES' },
    // ];
    

    // const restaurantes= restaurante.map(restaurante_ => <RestauranteComponente setRestaurante={setRestaurante} restaurante_={restaurante_}/>);
    console.log();
    const countryTemplate = (option: { name: string ; code: string; }) => {
        return (
            <div className="country-item">
                <div>
                    <img alt="logoTicomo" src="logoTicomo.png"  height="40" className="mr-2"></img>

                </div>
                {/* <div>{restaurante.map(restaurante_ => <RestauranteComponente setRestaurante={setRestaurante} restaurante_={restaurante_}/>)}</div> */}
                {/* <Button style={{ position: "relative" , left:"1450px" }} > x</Button> */}
                <div>{option.name}</div>
            </div>
        );
    }


    return (
        <div className="card">
            
            <ListBox value={selectedRestaurantes} options={restaurante} onChange={(e) => setSelectedRestaurantes(e.value)} multiple filter optionLabel="name"
                itemTemplate={countryTemplate} style={{ width: '95em' }} listStyle={{ maxHeight: '600px' }}  />

            
        </div>
    );
}

export default ListaRestaurantes;