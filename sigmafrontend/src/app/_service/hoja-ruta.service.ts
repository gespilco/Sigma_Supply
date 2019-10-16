import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';
import { HojaRuta } from '../_model/hoja-ruta';


@Injectable({
  providedIn: 'root'
})
export class HojaRutasService {
  url = `${HOST}/hojaRutas`;

  constructor(private http: HttpClient) { }

  listarHojaRutas() {
    return this.http.get(this.url);
  }

  listarHojaRutaId(id: number) {
    return this.http.get(this.url + '/' + id);
  }
  
  registrarHojaRuta(model: HojaRuta) {
    
    return this.http.post(this.url, model);
  }

  actualizarHojaRuta(model: HojaRuta) {

    return this.http.put(this.url, model);
  }
  
  eliminarHojaRuta(idHojaRuta): Observable<any> {
    return this.http.delete(this.url + '/' + idHojaRuta);
  }

  generarHojaRuta(idProgramaVisita): Observable<any> {
    return this.http.post(this.url + '/generarHojaRuta/' + idProgramaVisita,null);
  }

  vizualizarHojaRuta(idProgramaVisita): Observable<any> {
    return this.http.post(this.url + '/verHojaRuta/' + idProgramaVisita,null);
  }
  listarHojaRuta(idProgramaVisita):Observable<any>{
    return this.http.post(this.url + '/listarHojaRuta/' + idProgramaVisita,null);
  }
}
