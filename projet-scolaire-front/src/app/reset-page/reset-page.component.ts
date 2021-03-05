import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { param } from 'jquery';
import { ResetService } from '../service/reset.service';

@Component({
  selector: 'app-reset-page',
  templateUrl: './reset-page.component.html',
  styleUrls: ['./reset-page.component.css'],
})
export class ResetPageComponent implements OnInit {
  model: any = {};
  constructor(
    private authService: ResetService,
    private router: Router,
    private activate: ActivatedRoute
  ) {}

  ngOnInit(): void {}
  changePassword(f: NgForm) {
    this.activate.queryParams.subscribe((param) => {
      this.authService.changePassword(f.value.password, param.nom).subscribe(
        () => {
          this.router.navigate(['/login']);
        },
        (error) => {
          console.log(error);
        }
      );
    });
  }
}
