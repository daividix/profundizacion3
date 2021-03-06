import { Component, OnInit } from '@angular/core';
import { SignUpInfo } from 'src/app/models/signup-info';
import { AuthService } from 'src/app/services/auth/auth.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

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
  onRegister = false;
  keyup = {
    name: false,
    username: false,
    password: false,
    email: false
  };
  openAlert = false;
  alert = {
    message: '',
    type: ''
  };
  constructor(private authentication: AuthService, private _formBuilder: FormBuilder,
    private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(60)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(40)]]
    });
  }

  signup() {
    this.onRegister = true;
    const form = this.firstFormGroup.getRawValue();
    this.signUpForm = new SignUpInfo(form.name, form.lastName, form.gender,
      form.image, form.username, form.email, form.password);
      for (const key in form) {
        if (form.hasOwnProperty(key)) {
          const element = form[key];
          if (!element) {
            this.alert.message = 'Porfavor revisa que esten bien todos los campos';
            this.alert.type = 'danger';
            this.openAlert = true;
            return;
          }
        }
      }
    this.authentication.signUp(this.signUpForm)
    .subscribe(res => {
      console.log(res);
      if (res) {
        if (res.isOk) {
          this.alert.type = 'success';
          this.alert.message = 'Ya puedes iniciar sesion';
          this.openAlert = true;
          setTimeout(() => {
            this.router.navigate(['/login']);
          }, 1000);
          this.onRegister = false;
        } else {
          this.alert.type = 'danger';
          this.alert.message = res.message;
          this.openAlert = true;
          this.onRegister = false;
          return;
        }
      }
    });
  }

  firstFormError(input: string) {
    if (input === 'name') {
      if (this.firstFormGroup.controls['name'].errors == null) {
        return;
      }
      return this.firstFormGroup.controls['name'].errors.required ? 'Nombre requerido' :
      this.firstFormGroup.controls['name'].errors.minlength ? 'Minimo 2 caracteres' :
      this.firstFormGroup.controls['name'].errors.maxlength ? 'Maximo 40 caracteres' :
      '';
    }
    if (input === 'username') {
      if (this.firstFormGroup.controls['username'].errors == null) {
        return;
      }
      return this.firstFormGroup.controls['username'].errors.required ? 'username requerido' :
      this.firstFormGroup.controls['username'].errors.minlength ? 'Minimo 3 caracteres' :
      this.firstFormGroup.controls['username'].errors.maxlength ? 'Maximo 20 caracteres' :
      '';
    }
    if (input === 'email') {
      if (this.firstFormGroup.controls['email'].errors == null) {
        return;
      }
      return this.firstFormGroup.controls['email'].errors.required ? 'Email requerido' :
      this.firstFormGroup.controls['email'].errors.email ?  'Email invalido' :
      this.firstFormGroup.controls['email'].errors.maxlength ? 'Maximo 60 caracteres ' :
      '';
    }
    if (input === 'password') {
      if (this.firstFormGroup.controls['password'].errors == null) {
        return;
      }
      return this.firstFormGroup.controls['password'].errors.required ? 'Password requerido' :
      this.firstFormGroup.controls['password'].errors.minlength ?  'Minimo 8 caracteres' :
      this.firstFormGroup.controls['password'].errors.maxlength ? 'Maximo 40 caracteres' :
      '';
    }
  }
}
