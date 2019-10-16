import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';
import { Programacion } from '../_model/programacion';


@Injectable({
  providedIn: 'root'
})
export class ProgramacionService {
  url = `${HOST}/programaciones`;

  constructor(private http: HttpClient) { }1

  listarProgramacion() {
    return this.http.get(this.url);
  }

  listarProgramacionId(id: number) {
    return this.http.get(this.url + '/' + id);
  }
  
  registrarProgramacion(model: Programacion) {
    
    return this.http.post(this.url, model);
  }

  actualizarProgramacion(model: Programacion) {

    return this.http.put(this.url, model);
  }
  
  eliminarProgramacion(idProgramacion): Observable<any> {
    return this.http.delete(this.url + '/' + idProgramacion);
  }
}
