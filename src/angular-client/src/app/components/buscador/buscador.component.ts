import { Component, OnInit } from '@angular/core';

import { SiteService } from '../../services/site.service';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent implements OnInit {

  constructor(private data: SiteService) { }

  sitiosBuscados$: object;
  nombre: string = '';
  
  ngOnInit() {
  }
  realizarBusqueda(){
    this.data.buscarSitios(this.nombre).subscribe(res => {
      console.log(res);
      if (res.isOk) {
        this.sitiosBuscados$=res.results; 
      }
    });
  }


}
