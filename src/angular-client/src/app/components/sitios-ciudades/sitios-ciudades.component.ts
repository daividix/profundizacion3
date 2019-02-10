import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-sitios-ciudades',
  templateUrl: './sitios-ciudades.component.html',
  styleUrls: ['./sitios-ciudades.component.scss'],

})
export class SitiosCiudadesComponent implements OnInit {

  constructor(private data: DataService) { }

  datos$: object;
  ciudades$: object;

  ngOnInit() {
    this.data.getSitios().subscribe(
      data => this.datos$ = data
    );
    this.data.getCiudades().subscribe(
      data => this.ciudades$ = data
    );
  }

}
