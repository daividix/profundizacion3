import { Component, OnInit } from '@angular/core';
import { SignUpInfo } from 'src/app/models/signup-info';
import { AuthService } from 'src/app/services/auth/auth.service';

export interface Gender {
  value: string;
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm: SignUpInfo = new SignUpInfo();
  genders: Gender[] = [{value: 'Male'}, {value: 'Female'}];

  constructor(private authentication: AuthService) { }

  ngOnInit() {
  }

  signup() {
    this.authentication.signUp(this.signUpForm)
    .subscribe(res => {
      console.log(res);
    });
  }
}
