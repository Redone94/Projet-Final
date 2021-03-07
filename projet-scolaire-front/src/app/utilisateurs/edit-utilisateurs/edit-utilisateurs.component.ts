import { UtilisateurService } from './../../service/utilisateur.service';
import { Utilisateur } from './../../model/utilisateur';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-utilisateurs',
  templateUrl: './edit-utilisateurs.component.html',
  styleUrls: ['./edit-utilisateurs.component.css'],
})
export class EditUtilisateursComponent implements OnInit {
  @Input()
  utilisateur: Utilisateur = new Utilisateur();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(
    private utilisateurService: UtilisateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((param) => {
      if (param.id) {
        this.utilisateurService.findByIdInt(param.id).subscribe((data) => {
          this.utilisateur = data;
          console.log(this.utilisateur);
        });
      }
    });
    if (!this.utilisateur.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.utilisateur.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.utilisateur.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
    this.router.navigate(['/utilisateurs']);
  }

  public save() {
    if (this.utilisateur.id) {
      this.utilisateurService.update(this.utilisateur).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.utilisateurService.insert(this.utilisateur).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }

  private goList(info: Object) {
    this.router.navigate(['/utilisateurs'], { queryParams: info });
  }
}
