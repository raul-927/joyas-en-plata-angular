import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {Cliente} from '../domains/Cliente';
import {PROPIEDADES} from '../domains/Propiedades';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private url: string = PROPIEDADES.host + '/cliente/';

  data: Cliente[];

  constructor(private http: Http) {

   }

  public getClientes(): Observable<Cliente[]> {

    const clientes: Observable<Cliente[]> = this.http.get(this.url).pipe(
      map (data => data.json()),
      catchError((error, caught) => {
        console.log('Error Occurred' + caught);
        console.log(error);
        return Observable.throw(error);
      })) as any;
    console.log('Data: ' + JSON.stringify(clientes));
    return clientes;
  }
}
