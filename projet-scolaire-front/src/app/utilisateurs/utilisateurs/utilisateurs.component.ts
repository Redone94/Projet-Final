import {
  Component,
  OnInit
} from '@angular/core';
import { Router } from '@angular/router';

import { UtilisateurService } from 'src/app/service/utilisateur.service';

import { Utilisateurs } from '../../model/utilisateurs';

@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css'],
})
export class UtilisateursComponent implements OnInit {
  utilisateurs: Utilisateurs[] = [];

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.utilisateurService.allUtilisateur().subscribe((data) => {
      this.utilisateurs = data;

      console.log(data);
    });
  }
  public delete(id: number) {
    this.utilisateurService.delete(id).subscribe((result) => {
      this.init();
    });
  }

  public findById() {}
}
