import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TipoSolicitudService {

  url = `${HOST}/tipoSolicitudes`;

  constructor(private http: HttpClient) { }

  listarTipoSolicitud(): Observable<any> {
    return this.http.get(this.url);
  }
}