import { Component, OnInit } from '@angular/core';
import { AuthLoginInfo } from 'src/app/models/login-info';
import { AuthService } from 'src/app/services/auth/auth.service';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: AuthLoginInfo = new AuthLoginInfo();
  constructor(private authentication: AuthService, private tokenService: TokenStorageService) { }

  ngOnInit() {
  }

  login() {
    this.authentication.login(this.loginForm)
    .subscribe(res => {
      console.log(res);
      if (res.accessToken) {
        this.tokenService.saveToken(res.accessToken);
        this.tokenService.saveAuthorities(res.authorities);
        this.tokenService.saveUsername(res.username);
        window.location.assign('/');
      }

    });
  }
}
