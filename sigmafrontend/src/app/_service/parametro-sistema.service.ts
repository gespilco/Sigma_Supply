import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HOST } from '../_shared/var.constant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParametroSistemaService{

  url = `${HOST}/parametroSistema`;

  constructor(private http: HttpClient) { }

  listarParametroServicio(): Observable<any> {
    return this.http.get(this.url);
  }

  listarParametroServicioId(id) {
    return this.http.get(this.url + '/' + id);
  }

  listarParametroSistemaSol(idSolicitud): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.post(this.url + '/listarParametroSistemaTec/' + idSolicitud , null);
  }

}