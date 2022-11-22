
import React, { useState, useEffect, useRef } from "react";
import { RiderService } from '../../service/RiderService'
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";
import { DataTable, DataTableSelectParams } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { event } from "jquery";
import { Toast } from 'primereact/toast';
import axios from "axios";
import { getData } from "../../resources/api-constants";


export interface IValoraciones{
    valoraciones: string
}

const Valoraciones = () => {

const [valoraciones, setValoraciones] =useState<IValoraciones[]>([]);
const riderService = new RiderService();



    useEffect(() => {
        
      }, []);
      return (
        <div>
           
            <div className="card">
                <DataTable value={valoraciones} responsiveLayout="scroll">
                    {/*  <Column field="id" header="id"></Column> */}
                    <Column field={":data"} header="Valoraciones"></Column>
                    
                </DataTable>
            </div>

        </div>
    )
}

export default Valoraciones;