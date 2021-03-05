import { ClasseService } from 'src/app/service/classe.service';

import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Classe } from 'src/app/model/classe';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-classes',
  templateUrl: './edit-classes.component.html',
  styleUrls: ['./edit-classes.component.css']
})
export class EditClassesComponent implements OnInit {

  @Input()
  classe: Classe = new Classe();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private classeService: ClasseService,
    private activatedRoute: ActivatedRoute,
  private router: Router,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(param=>{
     if( param.id){
      this.classeService.findById(param.id).subscribe(data=>{
        this.classe=data;
        console.log(this.classe);
      })
     }
    } )
    if (!this.classe.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.classe.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.classe.id) {
      console.log('here');
      this.cancelEvent.emit();
    }this.router.navigate(['/classes']);
  }

  public save() {
    if (this.classe.id) {
      this.classeService.update(this.classe).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.classeService.insert(this.classe).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }

  private goList(info: Object) {
    this.router.navigate(['/classes'], { queryParams: info });
  }
}

