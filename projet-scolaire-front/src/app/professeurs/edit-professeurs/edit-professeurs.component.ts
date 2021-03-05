import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etablissement } from 'src/app/model/etablissement';
import { Matiere } from 'src/app/model/matiere';
import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'app-edit-professeurs',
  templateUrl: './edit-professeurs.component.html',
  styleUrls: ['./edit-professeurs.component.css']
})
export class EditProfesseursComponent implements OnInit {
  @Input()
  professeur: Professeur = new Professeur();
etablissement:Etablissement[]=[];
matiere: Matiere[]=[];

edit: boolean = false;
@Output('delete')
deleteEvent: EventEmitter<number> = new EventEmitter();
@Output('insert')
insertEvent: EventEmitter<void> = new EventEmitter();
@Output('cancel')
cancelEvent: EventEmitter<void> = new EventEmitter();


  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private professeurService: ProfesseurService,

  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.professeurService.findById(params.id).subscribe((data) => {
          this.professeur = data;
        })
      }
     } )
     if (!this.professeur.id) {
       this.changeMode();
     }
   }
  public save() {
    if (this.professeur.id) {
      this.professeurService.update(this.professeur).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.professeurService.insert(this.professeur).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }
  private goList(info: Object) {
    this.router.navigate(['/professeurs'], { queryParams: info });
   }
   public delete() {
    this.deleteEvent.emit(this.professeur.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }
  public cancel() {
    this.changeMode();
    if (!this.professeur.id) {
      console.log('here');
      this.cancelEvent.emit();
    }this.router.navigate(['/professeurs']);
  }


}
