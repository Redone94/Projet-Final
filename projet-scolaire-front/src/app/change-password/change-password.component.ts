import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css'],
})
export class ChangePasswordComponent implements OnInit {
  model: any = {};
  password: string;
  constructor(private authService: LoginService) {}

  ngOnInit(): void {}
  changePassword(f: NgForm) {
    this.authService.changePassword(this.model, f.value.password).subscribe(
      () => {},
      (error) => {
        console.log(error);
      }
    );
  }
}
