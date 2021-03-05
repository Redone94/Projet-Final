import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Etablissement } from 'src/app/model/etablissement';
import { EtablissementService } from 'src/app/service/etablissement.service';

@Component({
  selector: 'app-list-etablissements',
  templateUrl: './list-etablissements.component.html',
  styleUrls: ['./list-etablissements.component.css']
})
export class ListEtablissementsComponent implements OnInit {

  etablissement: Etablissement[]=[];
  

  constructor(private etabliService: EtablissementService, private router: Router) { 

    
  }

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
public findById(){}

}
