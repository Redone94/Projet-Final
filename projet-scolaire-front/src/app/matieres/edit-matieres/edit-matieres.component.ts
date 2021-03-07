import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output
} from '@angular/core';
import {
  ActivatedRoute,
  Router
} from '@angular/router';

import { Matiere } from 'src/app/model/matiere';
import { matiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-edit-matieres',
  templateUrl: './edit-matieres.component.html',
  styleUrls: ['./edit-matieres.component.css'],
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

  constructor(
    private matiereService: matiereService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((param) => {
      if (param.id) {
        this.matiereService.findById(param.id).subscribe((data) => {
          this.matiere = data;
          console.log(this.matiere);
        });
      }
    });
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
    this.router.navigate(['/matieres']);
  }

  public save() {
    if (this.matiere.id) {
      this.matiereService.update(this.matiere).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.matiereService.insert(this.matiere).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }

  private goList(info: Object) {
    this.router.navigate(['/matieres'], { queryParams: info });
  }
}
