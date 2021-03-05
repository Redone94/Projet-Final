import {
  Component,
  OnInit
} from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';

import { Login } from 'src/app/model/login';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginCtrl: FormControl;
  pwdCtrl: FormControl;
  confirmCtrl: FormControl;
  form: FormGroup;
  login: Login;
  erreur: boolean = false;
  passwordGoup: FormGroup;
  _user: string = '';

  constructor(
    private LoginService: LoginService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.loginCtrl = this.fb.control('', [
      Validators.required,
      Validators.minLength(3),
    ]);
    this.pwdCtrl = this.fb.control('', [Validators.minLength(3)]);

    this.form = this.fb.group({
      login: this.loginCtrl,
      password: this.pwdCtrl,
    });
  }

  ngOnInit(): void {}

  public logout() {
    sessionStorage.removeItem('tokenId');
    sessionStorage.removeItem('login');
    this._user = '';
    this.router.navigate(['/login']);
  }
  public user() {
    if (sessionStorage.getItem('tokenId')) {
      return true;
    }
    return false;
  }

  public send() {
    this.LoginService.auth(
      new Login(this.loginCtrl.value, this.pwdCtrl.value)
    ).subscribe(
      (result) => {
        sessionStorage.setItem(
          'tokenId',
          btoa(`${this.loginCtrl.value}:${this.pwdCtrl.value}`)
        );
        sessionStorage.setItem('login', this.loginCtrl.value);
        this.login = result;
        console.log(result);
        if (this.login.statut === true) {
          this.router.navigate(['/changepassword']);
        } else if (this.login.role === 'ROLE_ADMIN') {
          this.router.navigate(['/admin']);
        } else this.router.navigate(['/home']);
      },

      (error) => {
        this.erreur = true;
      }
    );
  }

  public loginIsInvalid(): boolean {
    return this.loginCtrl.dirty && this.loginCtrl.invalid;
  }
  public passwordIsInvalid(): boolean {
    return this.pwdCtrl.dirty && this.pwdCtrl.invalid;
  }
  public reset() {
    return this.router.navigate(['/reset']);
  }
}
