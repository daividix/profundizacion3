import { Component, OnInit } from '@angular/core';
import { SiteService } from '../../services/site.service';

@Component({
  selector: 'app-sitios-ciudades',
  templateUrl: './sitios-ciudades.component.html',
  styleUrls: ['./sitios-ciudades.component.scss'],

})
export class SitiosCiudadesComponent implements OnInit {

  constructor(private data: SiteService) { }

  sitios$: object;
  ciudades$: object; // variable para alojar el objeto de ciudades (falta el servicio)

  ngOnInit() {

    this.data.verSitios().subscribe(res => {
      console.log(res);
      if (res.isOk) {
        this.sitios$ = res.sitios;
      }
    });


  }

}
