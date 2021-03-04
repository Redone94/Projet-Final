import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Classe } from 'src/app/model/classe';
import { ClasseService } from 'src/app/service/classe.service';

@Component({
  selector: 'app-list-classes',
  templateUrl: './list-classes.component.html',
  styleUrls: ['./list-classes.component.css']
})
export class ListClassesComponent implements OnInit {

  classes: Classe[] = [];


  constructor(private matiereService : ClasseService, private router: Router) { }

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.matiereService.allClasse().subscribe((data) => {
      this.classes = data;

      console.log(data);
    });
  }
  public delete(id: number) {
    this.matiereService.delete(id).subscribe((result) => {
      this.init();
    });
  }


 public findById(){}



}
