import { EditMatieresComponent } from './matieres/edit-matieres/edit-matieres.component';
import { Routes } from '@angular/router';
import { ChangePasswordComponent } from './change-password/change-password.component';

import { ListClassesComponent } from './classes/list-classes/list-classes.component';
import { ListEtablissementsComponent } from './etablissements/list-etablissements/list-etablissements.component';
import { AccueilAdminComponent } from './home/accueil-admin.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login/login.component';
import { ListMatieresComponent } from './matieres/list-matieres/list-matieres.component';
import { ListProfesseursComponent } from './professeurs/list-professeurs/list-professeurs.component';
import { ResetComponent } from './reset/reset/reset.component';
import { ListSallesComponent } from './salles/list-salles/list-salles.component';
import { AdminGuardService } from './service/admin-guard.service';
import { UserGuardService } from './service/user-guard.service';
import { UtilisateursComponent } from './utilisateurs/utilisateurs/utilisateurs.component';
import { EditSallesComponent } from './salles/edit-salles/edit-salles.component';
import { ResetPageComponent } from './reset-page/reset-page.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reset', component: ResetComponent },
  {
    path: 'admin',
    component: AccueilAdminComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'home',
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
  {
    path: 'matieres/edit',
    component: EditMatieresComponent,
    canActivate: [AdminGuardService],
  },

  {
    path: 'salles',
    component: ListSallesComponent,
    canActivate: [AdminGuardService, UserGuardService],
  },
  {
    path: 'salles/edit/:id',
    component: EditSallesComponent,
    canActivate: [AdminGuardService],
  },

  {
    path: 'salles/edit',
    component: EditSallesComponent,
    canActivate: [AdminGuardService],
  },

  { path: 'classes', component: ListClassesComponent },
  {
    path: 'professeurs',
    component: ListProfesseursComponent,
    canActivate: [UserGuardService],
  },
  { path: 'changepassword', component: ChangePasswordComponent },
  { path: 'resetpassword', component: ResetPageComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
];
