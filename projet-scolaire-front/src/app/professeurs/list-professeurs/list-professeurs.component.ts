import {
  Component,
  OnInit
} from '@angular/core';
import { Router } from '@angular/router';

import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'app-list-professeurs',
  templateUrl: './list-professeurs.component.html',
  styleUrls: ['./list-professeurs.component.css'],
})
export class ListProfesseursComponent implements OnInit {
  professeur: Professeur[] = [];

  constructor(
    private professeurService: ProfesseurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initList();
  }
  public initList() {
    this.professeurService.allProfesseur().subscribe((data) => {
      this.professeur = data;
      console.log(data);
    });
  }
  public delete(id: number) {
    this.professeurService.delete(id).subscribe((result) => {
      this.initList();
    });
  }

  public findById() {}

  public canceladmin() {
    this.router.navigate(['/api/admin']);
  }
}
