import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Salle } from 'src/app/model/salle';
import { SalleService } from 'src/app/service/salle.service';

@Component({
  selector: 'app-edit-salles',
  templateUrl: './edit-salles.component.html',
  styleUrls: ['./edit-salles.component.css']
})
export class EditSallesComponent implements OnInit {

  @Input()
  salle: Salle = new Salle();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private salleService: SalleService) {}

  ngOnInit(): void {
    if (!this.salle.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.salle.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.salle.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
  }

  public save() {
    if (this.salle.id) {
      this.salleService.update(this.salle).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.salleService.insert(this.salle).subscribe((result) => {
        this.salle.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}

