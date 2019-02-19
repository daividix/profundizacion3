import { Component, OnInit } from '@angular/core';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';
import { SiteService } from '../../services/site.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [NgbRatingConfig]
})

export class HomeComponent implements OnInit {

  isLoggued: Boolean;

  constructor(private data: SiteService, config: NgbRatingConfig,
    private tokenService: TokenStorageService) {
    config.max = 5;
    config.readonly = true;
    if (this.tokenService.getUsername()) {
      this.isLoggued = true;
    }
   }

  sitiosPagados$: object;

  ngOnInit() {
    this.data.verSitios().subscribe(res => {
      console.log(res);
      if (res.isOk) {
        this.sitiosPagados$ = res.sitios;
      }
    });
  }

}
