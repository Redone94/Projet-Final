import { Routes } from '@angular/router';

import {
  ListEtablissementsComponent
} from './etablissements/list-etablissements/list-etablissements.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login/login.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'etablissements', component: ListEtablissementsComponent },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
