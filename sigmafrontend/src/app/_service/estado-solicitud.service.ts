import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from './../_shared/var.constant';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EstadoSolicitudService {

  url = `${HOST}/estadoSolicitudes`;

  constructor(private http: HttpClient) { }

  listarEstadoSolicitud(): Observable<any> {
    return this.http.get(this.url);
  }
}
