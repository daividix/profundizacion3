import { Component, OnInit } from '@angular/core';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [NgbRatingConfig]
})

export class HomeComponent implements OnInit {

  constructor( config: NgbRatingConfig ) {
    config.max = 5;
    config.readonly = true;
   }

  datos$: object;

  ngOnInit() {
    /*
    this.data.getSitios().subscribe(
      data => this.datos$ = data
    ); */
  }

}
