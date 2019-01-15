import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Busqueda } from '../models/busqueda';

@Injectable({
  providedIn: 'root'
})
export class BusquedaService {

  constructor(
    private http: HttpClient
  ) { }

  busqueda(lugar: string, ubicacion: string) {
    return this.http.get<Busqueda[]>(`http://localhost:8080/api/busqueda/simple/${lugar}/${ubicacion}`);
  }
}
