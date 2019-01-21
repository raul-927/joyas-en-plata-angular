import { Injectable } from '@angular/core';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
// import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
// import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Cliente} from '../domains/Cliente';
import {Propiedades} from '../domains/Propiedades';

@Injectable()
export class ClienteService {

  private urlGet: string = Propiedades.HOST + Propiedades.CLIENTES;
  private urlPost: string = Propiedades.HOST + Propiedades.CLIENTE;

  data: Object;

  constructor(private http: HttpClient) {

   }

  public getClientes(): Observable<Cliente[]> {
    const clientes: Observable<Cliente[]> = this.http.get<Cliente[]>(this.urlGet);
    return clientes;
  }

  public save(cliente: any): Observable<Cliente> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log('Cliente en service: ' + JSON.stringify(cliente));
    return this.http.post<Cliente>(this.urlPost, cliente, {headers: headers});
  }
}
