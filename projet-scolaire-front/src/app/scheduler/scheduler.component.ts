import { Component, Input, OnInit } from '@angular/core';

export interface events {
  Titre: String;
  Description: String;
  Début: Date;
  Fin: Date;
}
@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css'],
})
export class SchedulerComponent implements OnInit {
  constructor() {}
  @Input() événements: events[];
  startTime = '7:00';
  selectedDate = new Date();

  ngOnInit(): void {}
}
