import { Component, OnInit } from '@angular/core';
import { Etablissement } from 'src/app/model/etablissement';
import { EtablissementService } from 'src/app/service/etablissement.service';

@Component({
  selector: 'app-list-etablissements',
  templateUrl: './list-etablissements.component.html',
  styleUrls: ['./list-etablissements.component.css']
})
export class ListEtablissementsComponent implements OnInit {

  etablissement: Etablissement[]=[];
  showNew: boolean = false;

  constructor(private etabliService: EtablissementService) { }

  ngOnInit(): void {
    this.initList();
  }
public initList(){
  this.etabliService.allEtablissement().subscribe((data) => {
    this.etablissement= data;
    console.log(data);
  });
}
public delete(id: number){
  this.etabliService.delete(id).subscribe((result) => {
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
