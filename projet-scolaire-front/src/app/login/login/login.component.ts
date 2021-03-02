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

    this.loginCtrl=this.fb.control('',[Validators.required,Validators.minLength(3)])
    this.pwdCtrl=this.fb.control('',[Validators.minLength(3)])

    this.form=this.fb.group(
      {
      login: this.loginCtrl,
      password : this.pwdCtrl
    });

   }

  ngOnInit(): void {
  }

  public send()
  {
    this.LoginService.auth(new Login(this.loginCtrl.value, this.pwdCtrl.value)).subscribe((result) =>{

      sessionStorage.setItem('tokenId',btoa(`${this.loginCtrl.value}:${this.pwdCtrl.value}`)
      );
      sessionStorage.setItem('login', this.loginCtrl.value);
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




  }

