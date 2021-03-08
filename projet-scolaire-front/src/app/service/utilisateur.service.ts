import {
  HttpClient,
  HttpHeaders
} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Utilisateurs } from '../model/utilisateurs';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private url: string = 'http://localhost:8080/projetscolaire/api/compte';
  private HttpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

  public allUtilisateur(): Observable<Utilisateurs[]> {
    return this.http.get<Utilisateurs[]>(this.url, {
      headers: this.HttpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.HttpHeaders,
    });
  }

  public update(utilisateur: Utilisateurs): Observable<Utilisateurs> {
    return this.http.put<Utilisateurs>(
      `${this.url}/${utilisateur.id}`,
      utilisateur,
      {
        headers: this.HttpHeaders,
      }
    );
  }

  public insert(utilisateur: Utilisateurs): Observable<Utilisateurs> {
    const o = {
      id: utilisateur.id,
      login: utilisateur.login,
      password: utilisateur.password,
      mail: utilisateur.mail,
      tel: utilisateur.tel,
      //etablissement: [utilisateur.etablissement],
    };
    return this.http.post<Utilisateurs>(this.url, o, {
      headers: this.HttpHeaders,
    });
  }

  public findById(id: number): Observable<Utilisateurs> {
    return this.http.get<Utilisateurs>(this.url + '/' + id, {
      headers: this.HttpHeaders,
    });
  }
}
