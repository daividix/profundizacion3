import { Component, OnInit } from '@angular/core';
import { SiteService } from '../../services/site.service';

@Component({
  selector: 'app-sitios-ciudades',
  templateUrl: './sitios-ciudades.component.html',
  styleUrls: ['./sitios-ciudades.component.scss'],

})
export class SitiosCiudadesComponent implements OnInit {

  constructor(private data: SiteService) { }

  sitos$: object;
  ciudades$: object;

  ngOnInit() {

    this.data.verSitios().subscribe(
      data => this.sitos$ = data
    );

    console.log(this.sitos$);

    /*
    this.data.getSitios().subscribe(
      data => this.datos$ = data
    );
    this.data.getCiudades().subscribe(
      data => this.ciudades$ = data
    );*/

  }

}
