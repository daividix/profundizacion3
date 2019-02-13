import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sitios-result',
  templateUrl: './sitios-result.component.html',
  styleUrls: ['./sitios-result.component.scss']
})
export class SitiosResultComponent implements OnInit {

  sitiosAll$: object;

  constructor() { }

  ngOnInit() {
    /*
    this.data.getSitios().subscribe(
      data => this.sitiosAll$ = data
    ); */
  }

}
