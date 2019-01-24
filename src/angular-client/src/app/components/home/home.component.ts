import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../services/token/token-storage.service';
import { SiteService } from 'src/app/services/site.service';
import { Site } from 'src/app/models/site';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  showFiller = false;
  fixed = true;
  sites: Site[];
  constructor(private token: TokenStorageService, private siteService: SiteService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken() || '',
      username: this.token.getUsername() || '',
      authorities: this.token.getAuthorities() || []
    };
    this.siteService.verSitios()
    .subscribe(res => {
      if (res.isOk) {
        this.sites = res.sitios;
      }
    });
  }

  logout() {
    this.token.logOut();
    window.location.reload();
  }

}
