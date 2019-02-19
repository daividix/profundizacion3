import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sitioregistro',
  templateUrl: './sitioregistro.component.html',
  styleUrls: ['./sitioregistro.component.scss']
})
export class SitioregistroComponent implements OnInit {

  latitude: Number = 2.944286;
  longitude: Number = -75.298305;
  locationChosen: Boolean = false;

  onChoseLocation(event: any) {
    this.latitude = event.coords.lat;
    this.longitude = event.coords.lng;
    this.locationChosen = true;
  }

  constructor() { }

  ngOnInit() {
  }

}
