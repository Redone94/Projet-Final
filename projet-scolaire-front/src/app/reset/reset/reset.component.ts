import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css'],
})
export class ResetComponent implements OnInit {
  model: any = {};
  login: Login;
  constructor(private authService: LoginService, private router: Router) {}

  ngOnInit(): void {}
  onSubmit(f: NgForm) {
    const o = {
      email: f.value.email,
      numero: f.value.numberphone,
    };

    this.authService.resetPassword(this.model, o).subscribe((result) => {
      this.login = result;
      const o = {
        nom: this.login.login,
      };
      console.log(this.login);
      sessionStorage.setItem('tokenId', btoa(`reset:reset*123`));
      if (this.login.login != null) {
        console.log(this.login);
        this.router.navigate(['/resetpassword'], { queryParams: o });
      } else this.router.navigate(['/login']);
    });
  }
}
