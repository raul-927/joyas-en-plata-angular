import { Injectable } from '@angular/core';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
// import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
// import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Cuentas} from '../domains/Cuentas';
import {Propiedades} from '../statics/Propiedades';
import {UrlCuentas} from '../statics/UrlCuentas';

@Injectable({
  providedIn: 'root'
})
export class CuentasService {

  private urlGet: string = Propiedades.HOST + UrlCuentas.CUENTAS;

  private urlPost_Put_Delete: string = Propiedades.HOST + UrlCuentas.CUENTA;

  constructor(private httpClient: HttpClient) { }

  public insertCuenta(cuenta: any): Observable<Cuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.post<Cuentas>(this.urlPost_Put_Delete, cuenta, {headers: headers});
  }

  public updateCuenta(cuenta: Cuentas): Observable<Cuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.put<Cuentas>(this.urlPost_Put_Delete, cuenta, {headers: headers});
  }

  public deleteCuenta(id: any): Observable<Cuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-type', 'application/json');
    return this.httpClient.delete<Cuentas>(this.urlPost_Put_Delete + '/' + id);
  }

  public listAllCuentas(): Observable<Cuentas[]> {

    return this.httpClient.get<Cuentas[]>(this.urlGet);
  }

  public listCuentasByGrupoCuentaId(id: any): Observable<Cuentas> {
    return this.httpClient.get<Cuentas>(this.urlGet + '/' + id);
  }
}
