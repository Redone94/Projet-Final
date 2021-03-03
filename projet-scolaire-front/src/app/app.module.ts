import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import {
  FormsModule,
  ReactiveFormsModule
} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
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
  ListMatieresComponent
} from './matieres/list-matieres/list-matieres.component';
import {
  EditProfesseursComponent
} from './professeurs/edit-professeurs/edit-professeurs.component';
import {
  ListProfesseursComponent
} from './professeurs/list-professeurs/list-professeurs.component';
import { ResetComponent } from './reset/reset/reset.component';
import { routes } from './routes';
import { ListSallesComponent} from './salles/list-salles/list-salles.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { UtilisateursComponent} from './utilisateurs/utilisateurs/utilisateurs.component';
import { ListMatieresComponent } from './matieres/list-matieres/list-matieres.component';
import { ResetComponent } from './reset/reset/reset.component';
import { LoginComponent } from './login/login/login.component';
import { EditMatieresComponent } from './matieres/edit-matieres/edit-matieres.component';
import { EditClassesComponent } from './classes/edit-classes/edit-classes.component';
import { EditSallesComponent } from './salles/edit-salles/edit-salles.component';
import { AccueilAdminComponent } from './home/accueil-admin/accueil-admin.component';

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
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
