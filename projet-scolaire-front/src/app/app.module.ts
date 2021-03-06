import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import {
  FormsModule,
  ReactiveFormsModule
} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppComponent } from './app.component';
import {
  ChangePasswordComponent
} from './change-password/change-password.component';
import {
  EditClassesComponent
} from './classes/edit-classes/edit-classes.component';
import {
  ListClassesComponent
} from './classes/list-classes/list-classes.component';
import {
  EditEtablissementComponent
} from './etablissements/edit-etablissement/edit-etablissement.component';
import {
  ListEtablissementsComponent
} from './etablissements/list-etablissements/list-etablissements.component';
import { AccueilAdminComponent } from './home/accueil-admin.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login/login.component';
import {
  EditMatieresComponent
} from './matieres/edit-matieres/edit-matieres.component';
import {
  ListMatieresComponent
} from './matieres/list-matieres/list-matieres.component';
import { PlanningComponent } from './planning/planning.component';
import {
  EditProfesseursComponent
} from './professeurs/edit-professeurs/edit-professeurs.component';
import {
  ListProfesseursComponent
} from './professeurs/list-professeurs/list-professeurs.component';
import { ResetPageComponent } from './reset-page/reset-page.component';
import { ResetComponent } from './reset/reset/reset.component';
import { routes } from './routes';
import {
  EditSallesComponent
} from './salles/edit-salles/edit-salles.component';
import {
  ListSallesComponent
} from './salles/list-salles/list-salles.component';
import { SidebarComponent } from './sidebar/sidebar/sidebar.component';
import { Sidebar2Component } from './sidebar2/sidebar2.component';
import {
  EditUtilisateursComponent
} from './utilisateurs/edit-utilisateurs/edit-utilisateurs.component';
import {
  UtilisateursComponent
} from './utilisateurs/utilisateurs/utilisateurs.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    ListEtablissementsComponent,
    EditEtablissementComponent,
    ListProfesseursComponent,
    EditProfesseursComponent,
    ListSallesComponent,
    ListClassesComponent,
    UtilisateursComponent,
    ListMatieresComponent,
    ResetComponent,
    LoginComponent,
    EditMatieresComponent,
    EditClassesComponent,
    EditSallesComponent,
    AccueilAdminComponent,
    HomeComponent,
    ChangePasswordComponent,
    ResetPageComponent,
    Sidebar2Component,
    PlanningComponent,
    EditUtilisateursComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule,

    BrowserAnimationsModule,

    BrowserModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
