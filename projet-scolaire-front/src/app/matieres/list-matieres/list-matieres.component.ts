import { matiereService } from 'src/app/service/matiere.service';
import { Component, OnInit } from '@angular/core';
import { Matiere } from 'src/app/model/matiere';
import { Router } from '@angular/router';



@Component({
  selector: 'app-list-matieres',
  templateUrl: './list-matieres.component.html',
  styleUrls: ['./list-matieres.component.css']
})
export class ListMatieresComponent implements OnInit {


  matieres: Matiere[] = [];


  constructor(private matiereService : matiereService, private router: Router) { }

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.matiereService.allMatiere().subscribe((data) => {
      this.matieres = data;

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

