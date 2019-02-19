import { Injectable } from '@angular/core';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
// import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
// import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {GrupoCuentas} from '../domains/GrupoCuentas';
import {Propiedades} from '../statics/Propiedades';
import {UrlGrupoCuentas} from '../statics/UrlGrupoCuentas';


@Injectable({
  providedIn: 'root'
})
export class GrupoCuentasService {
  private urlGet: string = Propiedades.HOST + UrlGrupoCuentas.GRUPO_CUENTA;

  private urlPost_Put_Delete: string = Propiedades.HOST + UrlGrupoCuentas.GRUPO_CUENTA;

  constructor(private httpClient: HttpClient) { }

  public insertGrupoCuentas(grupoCuentas: any): Observable<GrupoCuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.post<GrupoCuentas>(this.urlPost_Put_Delete, grupoCuentas, {headers: headers});
  }

  public updateGrupoCuentas(grupoCuentas: GrupoCuentas): Observable<GrupoCuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.put<GrupoCuentas>(this.urlPost_Put_Delete, grupoCuentas, {headers: headers});
  }

  public deleteGrupoCuentas(id: any): Observable<GrupoCuentas> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-type', 'application/json');
    return this.httpClient.delete<GrupoCuentas>(this.urlPost_Put_Delete + '/' + id);
  }

  public listAllGrupoCuentas(): Observable<GrupoCuentas[]> {

    return this.httpClient.get<GrupoCuentas[]>(this.urlGet);
  }

  public getGrupoCuentaByGrupoCuentaId(id: any): Observable<GrupoCuentas> {
    return this.httpClient.get<GrupoCuentas>(this.urlGet + '/' + id);
  }
}
