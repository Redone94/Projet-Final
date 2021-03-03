import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etablissement } from 'src/app/model/etablissement';
import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'app-edit-professeurs',
  templateUrl: './edit-professeurs.component.html',
  styleUrls: ['./edit-professeurs.component.css']
})
export class EditProfesseursComponent implements OnInit {
professeur: Professeur = new Professeur();
etablissement:Etablissement[]=[];

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
        });
      }
    });
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
    this.router.navigate(['/professeur'], { queryParams: info });
   }


}
