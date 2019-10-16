import { Injectable } from '@angular/core';
import { Busqueda } from '../_model/busqueda';

@Injectable({
  providedIn: 'root'
})
export class ActualizaService {

  public numeroPagina: number;
  public busqueda:Busqueda;


  constructor() { }

  seteo(numpag,busquedaSe){
    this.numeroPagina=numpag;
    this.busqueda=busquedaSe;
  }
  
}
