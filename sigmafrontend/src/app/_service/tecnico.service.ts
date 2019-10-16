import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {
  url = `${HOST}/tecnicos`;

  constructor(private http: HttpClient) { }

  listarTecnicoAlgoritmo(idSolicitud): Observable<any> {
    return this.http.get(this.url + '/listarTecnicoHeuristica/' + idSolicitud);
  }

  listarTecnicos() {
    return this.http.get(this.url);
  }

  listarTecnicoId(id: number) {
    return this.http.get(this.url + '/' + id);
  }
}
