import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { data, param } from 'jquery';
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

  constructor(private salleService: SalleService,
    private activatedRoute: ActivatedRoute,
  private router: Router,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(param=>{
     if( param.id){
      this.salleService.findById(param.id).subscribe(data=>{
        this.salle=data;
        console.log(this.salle);
      })
     }
    } )
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
        this.goList({ info: 'update' });
      });
    } else {
      this.salleService.insert(this.salle).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }

  private goList(info: Object) {
    this.router.navigate(['/salles'], { queryParams: info });
  }
}

