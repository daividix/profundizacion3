import { Component, OnInit } from '@angular/core';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [NgbRatingConfig]
})

export class HomeComponent implements OnInit {
  isLoggued: Boolean;
  constructor( config: NgbRatingConfig,
    private tokenService: TokenStorageService) {
    config.max = 5;
    config.readonly = true;
    if (this.tokenService.getUsername()) {
      this.isLoggued = true;
    }
   }

  datos$: object;

  ngOnInit() {
    /*
    this.data.getSitios().subscribe(
      data => this.datos$ = data
    ); */

  }

}
