import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css'],
})
export class ChangePasswordComponent implements OnInit {
  model: any = {};
  constructor(
    private route: ActivatedRoute,
    private authService: LoginService
  ) {}

  ngOnInit(): void {}
  changePassword() {
    this.authService.changePassword(this.model).subscribe(
      () => {},
      (error) => {
        console.log(error);
      }
    );
  }
}
