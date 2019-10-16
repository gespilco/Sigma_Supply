import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TipoPrioridadService {

  url = `${HOST}/tipoPrioridades`;

  constructor(private http: HttpClient) { }

  listarTipoPrioridad(): Observable<any> {
    return this.http.get(this.url);
  }
}
