import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HOST } from '../_shared/var.constant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdenServicioService {

  url = `${HOST}/ordenServicios`;

  constructor(private http: HttpClient) { }

  listarOrdenServicio(): Observable<any> {
    return this.http.get(this.url);
  }

  listarOrdenServicioId(id) {
    return this.http.get(this.url + '/' + id);
  }

  listarOrdenServicioPar(idOrdenServicio, fechaRecepcion, idTipoSolicitud, idEstado): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.post(this.url + '/listarOrdenServicio/' + idOrdenServicio + '/' + fechaRecepcion + '/' + idTipoSolicitud + '/' + idEstado, null);
  }


  listarOrdenServicioPag(idOrdenServicio, fechaRecepcion, idTipoSolicitud, idEstado, skip, take): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.post(this.url + '/listarOrdenServicioPag/' + idOrdenServicio + '/' + fechaRecepcion + '/' + idTipoSolicitud + '/' + idEstado + '/' + skip + '/' + take, null);
  }

  listarOrdenServicioPagNum(numOrdenServicio, fechaRecepcion, idTipoSolicitud, idEstado, skip, take): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.post(this.url + '/listarOrdenServicioPagNum/' + numOrdenServicio + '/' + fechaRecepcion + '/' + idTipoSolicitud + '/' + idEstado + '/' + skip + '/' + take, null);
  }
}
