import { Component, OnInit } from '@angular/core';
import { BusquedaService } from '../../services/busqueda.service';
import { Busqueda } from '../../models/busqueda';

@Component({
  selector: 'bar-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  value: string = '';
  value1: string = '';
  sitios: Busqueda[];

  constructor(private busquedaService: BusquedaService) { }

  ngOnInit() {
  }

  enviarDatos() {
    /* let datos = [{ "lugar": lugar.value, "ubicacion": ubicacion.value }]
     console.log(datos);*/

    this.busquedaService.busqueda(this.value, this.value1).subscribe(res => {

      this.sitios = res;

    }, err => {

    });

  }
}
