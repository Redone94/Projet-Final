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
  constructor() {}

  ngOnInit() {
    //Toggle Click Function
    $('#menu-toggle').click(function (e) {
      e.preventDefault();
      $('#wrapper').toggleClass('toggled');
    });
  }
}
