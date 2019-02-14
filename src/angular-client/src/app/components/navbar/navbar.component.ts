import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';
import { Router } from '@angular/router';
import { SiteService } from 'src/app/services/site.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isLoggued: Boolean = false;
  username: String;
  searchContent: String;
  @Input() activateSearch: Boolean;
  constructor(private tokenService: TokenStorageService,
    private router: Router,
    private siteService: SiteService) {
    if (this.tokenService.getUsername()) {
      this.isLoggued = true;
      this.username = this.tokenService.getUsername();
    }
  }

  ngOnInit() {

  }

  logout() {
    this.tokenService.logOut();
    this.router.navigateByUrl('/navbar').then(() => {
      this.router.navigate(['/']);
    });
  }

  searchSite() {
    this.siteService.buscarSitios(this.searchContent)
    .subscribe(res => {
      console.log(res);
      this.searchContent = '';
    });
  }
}
