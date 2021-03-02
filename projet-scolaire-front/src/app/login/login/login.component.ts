import { Observable } from 'rxjs';
import { LoginService } from './../../service/login.service';

import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators,ValidationErrors, AsyncValidatorFn, AbstractControl } from '@angular/forms';
import { Login } from 'src/app/model/login';
import { Router } from '@angular/router';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginCtrl: FormControl;
  pwdCtrl: FormControl;
  confirmCtrl:FormControl;
  form: FormGroup;
  login: Login;
  erreur: boolean=false;
  passwordGoup: FormGroup;


  constructor(private LoginService: LoginService, private router: Router, private fb : FormBuilder) {

    this.loginCtrl=this.fb.control([Validators.required,Validators.minLength(8)], this.checkLogin())
    this.pwdCtrl=this.fb.control([Validators.minLength(6),Validators.pattern(/^(?=.*\d)(?=.*[a-zA-Z])([a-zA-Z0-9]{3,})$/),])
    this.confirmCtrl = this.fb.control(Validators.required)

    this.passwordGoup=this.fb.group(
      {
        password: this.pwdCtrl,
        confirm: this.confirmCtrl
      },
      { validator: this.checkPassword
      }
      );


    this.form=this.fb.group(
      {
      login: this.loginCtrl,
      passGroup:this.passwordGoup,
    });

   }

  ngOnInit(): void {
  }

  private checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.LoginService.checkLogin(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { loginExist: true } : null;
        })
      );
    };
  }

  private checkPassword(group: FormGroup) {
    const password = group.controls.password;
    const confirm = group.controls['confirm'];
    if (password.errors) {
      return null;
    }
    return password.value !== confirm.value ? { notEquals: true } : null;
  }

  public send()
  {
    this.LoginService.auth(new Login(this.loginCtrl.value, this.pwdCtrl.value)).subscribe((result) =>{

      sessionStorage.setItem('tokenId',btoa(`${this.login.username}:${this.login.password}`)
      );
      sessionStorage.setItem('login', this.login.username);
      this.router.navigate(['/reset']);
    },
    (error) => {
      this.erreur = true;
    }
  );
    };

    public loginIsInvalid(): boolean {
      return this.loginCtrl.dirty && this.loginCtrl.invalid;
      }
      public passwordIsInvalid(): boolean {
      return this.pwdCtrl.dirty && this.pwdCtrl.invalid;
      }

      public confirmNotEquals(): boolean {
      return this.confirmCtrl.dirty && this.passwordGoup.invalid;
      }



  }

