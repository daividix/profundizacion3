import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }


  getSitios() {
    return this.http.get('http://localhost:3000/sitios');
  }

  getSitio(sitioId) {
    return this.http.get('http://localhost:3000/sitios/' + sitioId);
  }

  getCiudades() {
    return this.http.get('http://localhost:3000/ciudades');
  }

  getCategories() {
    return this.http.get('http://localhost:3000/categorias');
  }

  getCategoriesResult(resultId) {
    return this.http.get('http://localhost:3000/categorias/' + resultId);
  }

}


