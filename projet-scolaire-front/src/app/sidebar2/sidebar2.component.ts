import {
  animate,
  state,
  style,
  transition,
  trigger
} from '@angular/animations';
import {
  Component,
  OnInit
} from '@angular/core';
import { Router } from '@angular/router';

import * as $ from 'jquery';

@Component({
  selector: 'app-sidebar2',
  templateUrl: './sidebar2.component.html',
  styleUrls: ['./sidebar2.component.css'],
  animations: [
    trigger('slide', [
      state('up', style({ height: 0 })),
      state('down', style({ height: '*' })),
      transition('up <=> down', animate(200)),
    ]),
  ],
})
export class Sidebar2Component implements OnInit {
  _user: string = '';
  constructor(private router: Router) {}
  ngOnInit() {
    //Click btn return sidebar
    $('#menu-toggle').click(function (e) {
      e.preventDefault();
      $('#wrapper').toggleClass('toggled');
    });
  }

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
}
