import { Component, OnInit } from '@angular/core';
import { SiteService } from 'src/app/services/site.service';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';

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
    phoneNumber: '',
    eslogan: '',
    city: '',
    categories: [],
    services: [],
    longitude: '',
    latitude: '',
    clicks: 0
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

  constructor(private siteService: SiteService, private tokenService: TokenStorageService) { }

  ngOnInit() {
  }

  crearSitio() {
    console.log('Authorities', this.tokenService.getAuthorities());
    console.log('token', this.tokenService.getToken());
  this.newSitio.latitude = this.latitude;
  this.newSitio.longitude = this.longitude;
  console.log(this.newSitio);
  this.siteService.crearSitio(this.newSitio)
  .subscribe(res => {
    console.log(res);
    alert(res.message);
  });

  }
}
