import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Matiere } from 'src/app/model/matiere';
import { MatiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-edit-matieres',
  templateUrl: './edit-matieres.component.html',
  styleUrls: ['./edit-matieres.component.css']
})
export class EditMatieresComponent implements OnInit {

  @Input()
  matiere: Matiere = new Matiere();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private matiereService: MatiereService) {}

  ngOnInit(): void {
    if (!this.matiere.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.matiere.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.matiere.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
  }

  public save() {
    if (this.matiere.id) {
      this.matiereService.update(this.matiere).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.matiereService.insert(this.matiere).subscribe((result) => {
        this.matiere.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}
