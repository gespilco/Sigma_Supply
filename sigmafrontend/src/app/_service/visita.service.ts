import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';
import { Visita } from '../_model/visita';

@Injectable({
  providedIn: 'root'
})
export class VisitasService {
  url = `${HOST}/visitas`;

  constructor(private http: HttpClient) { }

  listarVisitas() {
    return this.http.get(this.url);
  }

  listarVisitaId(id: number) {
    return this.http.get(this.url + '/' + id);
  }
  
  registrarVisita(model: Visita) {
    console.log(model);
    return this.http.post(this.url, model);
  }

  actualizarVisita(model: Visita) {

    return this.http.put(this.url, model);
  }
  
  eliminarVisita(idVisita): Observable<any> {
    return this.http.delete(this.url + '/' + idVisita);
  }
}
