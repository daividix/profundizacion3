import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { map } from 'rxjs/operators';
import { Site } from '../models/site'

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  domain: String = 'http://localhost:8090';
  constructor(private http: HttpClient) {}
  // comentario
  agregarSitio(nuevoSitio: Site) {
    return this.http.put<Site>(`${this.domain}/v1/site`, nuevoSitio)
    .pipe(map(res => res));
  }
}
