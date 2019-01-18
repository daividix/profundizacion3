import { Component, OnInit, Input } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input('drawer') drawer;
  isLogged: Boolean = false;
  constructor(public tokenService: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
  }

  logout() {
    this.tokenService.logOut();
    window.location.reload();
  }
}
