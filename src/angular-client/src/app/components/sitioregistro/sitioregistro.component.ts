import { Component, OnInit } from '@angular/core';
import { SiteService } from 'src/app/services/site.service';

@Component({
  selector: 'app-sitioregistro',
  templateUrl: './sitioregistro.component.html',
  styleUrls: ['./sitioregistro.component.scss']
})
export class SitioregistroComponent implements OnInit {
  newSitio: any = {
    name: '',
    address: '',
    calification: '',
    information: '',
    phone_number: '',
    eslogan: '',
    city: '',
    categories: [],
    services: [],
    longitude: '',
    latitude: ''
  };

  latitude: Number = 2.944286;
  longitude: Number = -75.298305;
  locationChosen: Boolean = false;

  onChoseLocation(event: any) {
    this.latitude = event.coords.lat;
    this.longitude = event.coords.lng;
    this.locationChosen = true;
    console.log(this.latitude, this.longitude);
  }

  constructor(private siteService: SiteService) { }

  ngOnInit() {
  }

  crearSitio() {

  this.newSitio.latitude = this.latitude;
  this.newSitio.longitude = this.longitude;
  console.log(this.newSitio);
  this.siteService.crearSitio(this.newSitio)
  .subscribe(res => {
    console.log(res);
  });

  }
}
