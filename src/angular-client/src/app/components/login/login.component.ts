import { Component, OnInit } from '@angular/core';
import { AuthLoginInfo } from 'src/app/models/login-info';
import { AuthService } from 'src/app/services/auth/auth.service';
import { TokenStorageService } from 'src/app/services/token/token-storage.service';
import { MatSnackBar } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorLogin: Boolean = false;
  errorMessage: String;
  loginForm: FormGroup;
  errorForm = {
    username: {
      value: false,
      msg: ''
    },
    password: {
      value: false,
      msg: ''
    }
  };
  constructor(private authentication: AuthService,
    private tokenService: TokenStorageService, private snackBar: MatSnackBar,
    private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.loginForm = this._formBuilder.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });
  }

  login() {
    const form = new AuthLoginInfo();
    if (!this.loginForm.getRawValue().username) {
      return this.snackBar.open('El username es requerido', 'Ok', {
        duration: 4000,
      });
    }
    if (!this.loginForm.getRawValue().password) {
      return this.snackBar.open('El password es requerido', 'Ok', {
        duration: 4000,
      });
    }
    form.username = this.loginForm.getRawValue().username;
    form.password = this.loginForm.getRawValue().password;
    this.authentication.login(form)
    .subscribe(res => {
      console.log('response', res);
      if (res.isOk) {
        this.tokenService.saveToken(res.result.accessToken);
        this.tokenService.saveAuthorities(res.result.authorities);
        this.tokenService.saveUsername(res.result.username);
        window.location.assign('/');
      } else {
        this.snackBar.open(res.message, 'Ok', {
          duration: 4000,
        });
      }

    });
  }

  getErrorMessageUsername() {
    if (this.loginForm.controls['password'].errors == null) {
      return;
    }
    return this.loginForm.controls['username'].errors.required ? 'Username requerido' :
            '';
  }
  getErrorMessagePassword() {
    if (this.loginForm.controls['password'].errors == null) {
      return;
    }
    return this.loginForm.controls['password'].errors.required ? 'Password requerido' :
    this.loginForm.controls['password'].errors.minlength ? 'Minimo 8 caracteres' :
            '';
  }
}
