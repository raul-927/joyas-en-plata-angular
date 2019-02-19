import { Injectable } from '@angular/core';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
// import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
// import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Department} from '../domains/Department';
import {Propiedades} from '../statics/Propiedades';
import {UrlDepartment} from '../statics/UrlDepartment';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private urlGet: string = Propiedades.HOST + UrlDepartment.DEPARTMENTS;

  private urlPost: string = Propiedades.HOST + UrlDepartment.DEPARTMENT;
  constructor(private http: HttpClient) { }


  public listAllDepartment(): Observable<Department[]> {

    return this.http.get<Department[]>(this.urlGet);
  }

  public insertDepartment(department: any): Observable<Department> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<Department>(this.urlPost, department, {headers: headers});
  }

  public updateDepartment(department: any): Observable<Department> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-type', 'application/json');

    return this.http.put<Department>(this.urlPost, department, {headers: headers});
  }

  public deleteDepartment(id: any): Observable<Department> {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-type', 'application/json');
    return this.http.delete<Department>(this.urlPost + id);
  }
}
