import { Injectable } from '@angular/core';
import { AuthLoginInfo } from 'src/app/models/login-info';
import { Observable } from 'rxjs';
import { JwtResponse } from 'src/app/models/jwt-response';
import { HttpClient } from '@angular/common/http';
import { SignUpInfo } from 'src/app/models/signup-info';
import { SignUpResponse } from 'src/app/models/signup-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = '/api/auth/signin';
  private signupUrl = '/api/auth/signup';

  constructor(private http: HttpClient) { }

  login(credentials: AuthLoginInfo): Observable<any> {
    return this.http.post<any>(this.loginUrl, credentials);
  }

  signUp(info: SignUpInfo): Observable<SignUpResponse> {
    return this.http.post<SignUpResponse>(this.signupUrl, info);
  }
}
