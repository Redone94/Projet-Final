import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css'],
})
export class ResetComponent implements OnInit {
  constructor(private authService: LoginService) {}

  ngOnInit(): void {}
  onSubmit(f: NgForm) {
    const resetPasswordObserver = {
      next: (x) => {
        console.log('Check email to change password');
      },
      error: (err) => {
        console.log(err);
      },
    };
    this.authService.resetPassword(f.value).subscribe(resetPasswordObserver);
  }
}
