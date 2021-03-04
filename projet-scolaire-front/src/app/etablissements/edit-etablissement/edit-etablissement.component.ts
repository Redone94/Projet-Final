import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Etablissement } from 'src/app/model/etablissement';
import { EtablissementService } from 'src/app/service/etablissement.service';

@Component({
  selector: 'app-edit-etablissement',
  templateUrl: './edit-etablissement.component.html',
  styleUrls: ['./edit-etablissement.component.css']
})
export class EditEtablissementComponent implements OnInit {
@Input()
etablissement: Etablissement= new Etablissement();
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
    private etabliService: EtablissementService,
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.etabliService.findById(params.id).subscribe((data) => {
          this.etablissement = data;
        })
      }
     } )
     if (!this.etablissement.id) {
       this.changeMode();
     }
   }
  public save() {
    if (this.etablissement.id) {
      this.etabliService.update(this.etablissement).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.etabliService.insert(this.etablissement).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }
  private goList(info: Object) {
    this.router.navigate(['/etablissement'], { queryParams: info });
   }
   public delete() {
    this.deleteEvent.emit(this.etablissement.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }
  public cancel() {
    this.changeMode();
    if (!this.etablissement.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
  }

}
