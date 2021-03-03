import { Component, OnInit } from '@angular/core';
import { data } from 'jquery';
import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';


@Component({
  selector: 'app-list-professeurs',
  templateUrl: './list-professeurs.component.html',
  styleUrls: ['./list-professeurs.component.css']
})
export class ListProfesseursComponent implements OnInit {

  professeur: Professeur[]=[];
  showNew: boolean = false;

  constructor(private professeurService: ProfesseurService) { }

  ngOnInit(): void {
    this.initList();
  }
public initList(){
  this.professeurService.allProfesseur().subscribe((data) => {
    this.professeur= data;
    console.log(data);
  });
}
public delete(id: number){
  this.professeurService.delete(id).subscribe((result) => {
  this.initList();
  });
}

public displayNew() {
  this.showNew = !this.showNew;
}

public insert() {
  this.displayNew();
  this.initList();
}

public cancel() {
  this.displayNew();
}



}
