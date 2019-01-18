import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../services/token/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  showFiller = false;
  fixed = true;
  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken() || '',
      username: this.token.getUsername() || '',
      authorities: this.token.getAuthorities() || []
    };
  }

  logout() {
    this.token.logOut();
    window.location.reload();
  }

}
