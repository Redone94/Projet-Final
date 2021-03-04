import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css'],
})
export class ResetComponent implements OnInit {
  model: any = {};

  constructor(private authService: LoginService) {}

  ngOnInit(): void {}
  onSubmit(f: NgForm) {
    const o = {
      email: f.value.email,
      numero: f.value.numberphone,
    };
    this.authService.resetPassword(this.model, o);
  }
}
