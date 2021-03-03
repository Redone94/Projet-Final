import { Routes } from '@angular/router';

import {
  ListClassesComponent
} from './classes/list-classes/list-classes.component';
import {
  ListEtablissementsComponent
} from './etablissements/list-etablissements/list-etablissements.component';
import {
  AccueilAdminComponent
} from './home/accueil-admin/accueil-admin.component';
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
import { AdminGuardService } from './service/admin-guard.service';
import { UserGuardService } from './service/user-guard.service';
import {
  UtilisateursComponent
} from './utilisateurs/utilisateurs/utilisateurs.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reset', component: ResetComponent },
  {
    path: 'home/accueil-admin',
    component: AccueilAdminComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'home/home',
    component: HomeComponent,
    canActivate: [UserGuardService],
  },
  {
    path: 'utilisateurs',
    component: UtilisateursComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'etablissements',
    component: ListEtablissementsComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'matieres',
    component: ListMatieresComponent,
    canActivate: [AdminGuardService],
  },
  { path: 'salles', component: ListSallesComponent },
  { path: 'classes', component: ListClassesComponent },
  {
    path: 'professeurs',
    component: ListProfesseursComponent,
    canActivate: [UserGuardService],
  },

  { path: '', redirectTo: 'login', pathMatch: 'full' },
];
