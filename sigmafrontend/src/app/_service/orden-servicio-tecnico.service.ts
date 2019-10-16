import { OrdenServicioTecnico } from './../_model/orden-servicio-tecnico';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdenServicioTecnicoService {

  url = `${HOST}/ordenServicioTecnicos`;

  constructor(private http: HttpClient) { }

  registrarOrdenServicioTecnico(model: OrdenServicioTecnico) {
    console.log(model);
    return this.http.post(this.url, model);
  }

  actualizarOrdenServicioTecnico(model: OrdenServicioTecnico) {

    return this.http.put(this.url, model);
  }

  listarOrdenServicioTecnico() {
    return this.http.get(this.url);
  }

  eliminarOrdenServiciosTecnico(idOrdenServicio): Observable<any> {
    return this.http.delete(this.url + '/' + idOrdenServicio);
  }
  
  listarOrdenServiciosTecnico(idOrdenServicio): Observable<any> {
    return this.http.get(this.url + '/listarOrdenServicioTecnico/' + idOrdenServicio);
  }

  obtenerOrdenServiciosTecnico(idOrdenServicio, idTecnico): Observable<any> {
    return this.http.get(this.url + '/objOrdenServicioTecnico/' + idOrdenServicio + '/' + idTecnico);
  }
}
