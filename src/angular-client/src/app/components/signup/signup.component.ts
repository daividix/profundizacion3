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
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(60)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(40)]]
    });
    this.secondFormGroup = this._formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(40)]],
      lastName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(60)]],
      gender: ['', Validators.required]
    });
  }

  signup() {
    const form1 = this.firstFormGroup.getRawValue();
    const form2 = this.secondFormGroup.getRawValue();
    const form = Object.assign(form1, form2);
    this.signUpForm = new SignUpInfo(form.name, form.lastName, form.gender,
      form.image, form.username, form.email, form.password);
      for (const key in form) {
        if (form.hasOwnProperty(key)) {
          const element = form[key];
          if (!element) {
            return this.snackBar.open(`El campo "${key}" es requerido`, 'Ok', {
              duration: 3000,
            });
          }
        }
      }
      for (const key in this.firstFormGroup.controls) {
        if (this.firstFormGroup.controls.hasOwnProperty(key)) {
          const element = this.firstFormGroup.controls[key];
          if (element.errors) {
            return this.snackBar.open(`Porfavor revisa el campo "${key}"`, 'Ok', {
              duration: 3000,
            });
          }
        }
      }
      for (const key in this.secondFormGroup.controls) {
        if (this.secondFormGroup.controls.hasOwnProperty(key)) {
          const element = this.secondFormGroup.controls[key];
          if (element.errors) {
            return this.snackBar.open(`Porfavor revisa el campo "${key}"`, 'Ok', {
              duration: 3000,
            });
          }
        }
      }
    this.authentication.signUp(this.signUpForm)
    .subscribe(res => {
      console.log(res);
      if (res) {
        if (res.isOk) {
          return this.snackBar.open('Te has registrado correctamente', 'Login', {
            duration: 6000,
          }).onAction().subscribe(action => {
            console.log(action);
            window.location.assign('/login');
          });
        } else {
          this.snackBar.open('Hubo un error al registrarse', 'Ok', {
            duration: 3000,
          });
        }
      }
    });
  }

  firstFormError(input: string) {
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

  secondFormError(input: string) {
    if (input === 'name') {
      if (this.secondFormGroup.controls['name'].errors == null) {
        return;
      }
      return this.secondFormGroup.controls['name'].errors.required ? 'Nombre requerido' :
      this.secondFormGroup.controls['name'].errors.minlength ? 'Minimo 2 caracteres' :
      this.secondFormGroup.controls['name'].errors.maxlength ? 'Maximo 40 caracteres' :
      '';
    }
    if (input === 'lastName') {
      if (this.secondFormGroup.controls['lastName'].errors == null) {
        return;
      }
      return this.secondFormGroup.controls['lastName'].errors.required ? 'Apellidos requerido' :
      this.secondFormGroup.controls['lastName'].errors.minlength ?  'Minimo 2 caracteres' :
      this.secondFormGroup.controls['lastName'].errors.maxlength ? 'Maximo 60 caracteres' :
      '';
    }
    if (input === 'gender') {
      if (this.secondFormGroup.controls['gender'].errors == null) {
        return;
      }
      return this.secondFormGroup.controls['gender'].errors.required ? 'Elije tu genero' :
      '';
    }
  }

  logger() {
    console.log(this.firstFormGroup.getRawValue());
  }
}
