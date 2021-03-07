import {
  HttpClient,
  HttpHeaders
} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Professeur } from '../model/professeur';

@Injectable({
  providedIn: 'root',
})
export class ProfesseurService {
  private url: string = 'http://localhost:8080/projetscolaire/api/professeur';

  private HttpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {}

  public allProfesseur(): Observable<Professeur[]> {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.get<Professeur[]>(this.url, { headers: this.HttpHeaders });
  }
  public delete(id: number): Observable<void> {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.HttpHeaders,
    });
  }
  public findById(id: number): Observable<Professeur> {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.get<Professeur>(this.url + '/' + id, {
      headers: this.HttpHeaders,
    });
  }
  public update(professeur: Professeur): Observable<Professeur> {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.put<Professeur>(
      `${this.url}/${professeur.id}`,
      professeur,
      { headers: this.HttpHeaders }
    );
  }
  public insert(professeur: Professeur): Observable<Professeur> {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    const o = {
      id: professeur.id,
      nom: professeur.nom,
      prenom: professeur.prenom,
      datenaissance: professeur.datenaissance,
      matiere: [professeur.matiere],

      adresse: {
        numero: professeur.adresse.numero,
        voie: professeur.adresse.voie,
        cp: professeur.adresse.cp,
        ville: professeur.adresse.ville,
      },

      image: professeur.logo,

      compte: {
        id: professeur.compte.id,
        login: professeur.compte.login,
        role: professeur.compte.role,
        etablissement: professeur.compte.etablissement,
      },
    };
    return this.http.post<Professeur>(this.url, o, {
      headers: this.HttpHeaders,
    });
  }
}
