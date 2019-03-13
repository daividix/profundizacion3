import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class SiteService {
  domain: String = '/api/v1/sitio';

  constructor(private http: HttpClient, private tokenService: TokenStorageService) { }

  public verSitios(): Observable<any> {
    return this.http.get(`${this.domain}/verSitios`);
  }

  public buscarSitios(nombre: String): Observable<any> {
    return this.http.get(`${this.domain}/buscarPorNombre/${nombre}`);
  }


  public crearSitio(sitio): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.tokenService.getToken()}`)
    return this.http.post(`${this.domain}/agregarSitio`, sitio, {
      headers: headers
    });
  }

  public VerSitioPorId(id: object): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.tokenService.getToken()}`)
    return this.http.post(`${this.domain}/verSitio/{id}`, id, {
      headers: headers
    });
  }


}
