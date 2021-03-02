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
import {
  EditProfesseursComponent
} from './professeurs/edit-professeurs/edit-professeurs.component';
import {
  ListProfesseursComponent
} from './professeurs/list-professeurs/list-professeurs.component';
import { routes } from './routes';
import {
  ListSallesComponent
} from './salles/list-salles/list-salles.component';
import { SidebarComponent } from './sidebar/sidebar.component';
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
