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
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
  animations: [
    trigger('slide', [
      state('up', style({ height: 0 })),
      state('down', style({ height: '*' })),
      transition('up <=> down', animate(200)),
    ]),
  ],
})
export class SidebarComponent implements OnInit {
  _user: string = '';
  constructor(private router: Router) {}
  ngOnInit() {
    //Toggle Click Function
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
