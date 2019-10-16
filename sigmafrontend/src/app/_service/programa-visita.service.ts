import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Observable } from 'rxjs';
import { ProgramaVisita } from '../_model/programavisita';

@Injectable({
  providedIn: 'root'
})
export class ProgramaVisitaService {

  url = `${HOST}/programavisita`;

  constructor(private http: HttpClient) { }

  listarVisitas() {
    return this.http.get(this.url);
  }

  listarVisitaId(id: number) {
    return this.http.get(this.url + '/' + id);
  }
  
  registrarVisita(model: ProgramaVisita) {
    console.log(model);
    return this.http.post(this.url, model);
  }

  actualizarVisita(model: ProgramaVisita) {

    return this.http.put(this.url, model);
  }
  
  eliminarVisita(idVisita): Observable<any> {
    return this.http.delete(this.url + '/' + idVisita);
  }

  listarProgramaVisita(idTecnico, fecha, skip, take): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.post(this.url + '/listarProgramaVisitaPag/' + idTecnico + '/' + fecha + '/' +  skip + '/' + take, null);
  }
}
