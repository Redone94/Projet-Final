import { Routes } from '@angular/router';

import {
  ListClassesComponent
} from './classes/list-classes/list-classes.component';
import {
  ListEtablissementsComponent
} from './etablissements/list-etablissements/list-etablissements.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login/login.component';
import {
  ListMatieresComponent
} from './matieres/list-matieres/list-matieres.component';
import {
  ListProfesseursComponent
} from './professeurs/list-professeurs/list-professeurs.component';
import { ResetComponent } from './reset/reset/reset.component';
import {
  ListSallesComponent
} from './salles/list-salles/list-salles.component';
import {
  UtilisateursComponent
} from './utilisateurs/utilisateurs/utilisateurs.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reset', component: ResetComponent },
  { path: 'home', component: HomeComponent },
  { path: 'utilisateurs', component: UtilisateursComponent },
  { path: 'etablissements', component: ListEtablissementsComponent },
  { path: 'matieres', component: ListMatieresComponent },
  { path: 'salles', component: ListSallesComponent },
  { path: 'classes', component: ListClassesComponent },
  { path: 'professeurs', component: ListProfesseursComponent },

  { path: '', redirectTo: 'login', pathMatch: 'full' },

];
