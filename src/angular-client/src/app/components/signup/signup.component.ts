import { Component, OnInit } from '@angular/core';
import { SignUpInfo } from 'src/app/models/signup-info';
import { AuthService } from 'src/app/services/auth/auth.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';

export interface Gender {
  value: string;
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm: SignUpInfo;
  form1: any = {};
  form2: any = {};
  genders: Gender[] = [{value: 'Male'}, {value: 'Female'}];
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  constructor(private authentication: AuthService, private _formBuilder: FormBuilder,
    private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      image: ['', Validators.required]
    });
  }

  signup() {
    const form1 = this.firstFormGroup.getRawValue();
    const form2 = this.secondFormGroup.getRawValue();
    const form = Object.assign(form1, form2);
    this.signUpForm = new SignUpInfo(form2.name, form2.lastName, form2.gender,
      form2.image, form1.username, form1.email, form1.password);
    console.log(this.signUpForm);
    this.authentication.signUp(this.signUpForm)
    .subscribe(res => {
      console.log(res);
      if (res.isOk) {
        this.snackBar.open('Te has registrado correctamente', 'Login', {
          duration: 6000,
        }).onAction().subscribe(action => {
          console.log(action);
          window.location.assign('/login');
        });
      }
      if (res.isOk === undefined) {
        this.snackBar.open('Hubo un error al registrarse', 'Ok', {
          duration: 3000,
        });
      }
    });
  }

  logger() {
    console.log(this.firstFormGroup.getRawValue());
  }
}
