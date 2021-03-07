import {
  HttpClient,
  HttpHeaders
} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Etablissement } from '../model/etablissement';

@Injectable({
  providedIn: 'root',
})
export class EtablissementService {
  private url: string =
    'http://localhost:8080/projetscolaire/api/etablissement';

  constructor(private http: HttpClient) {}

  public allEtablissement(): Observable<Etablissement[]> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    // console.log(sessionStorage.getItem('tokenId'));
    return this.http.get<Etablissement[]>(this.url, { headers: httpHeaders });
  }
  public delete(id: number): Observable<void> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.delete<void>(this.url + '/' + id, {
      headers: httpHeaders,
    });
  }
  public findById(id: number): Observable<Etablissement> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.get<Etablissement>(this.url + '/' + id, {
      headers: httpHeaders,
    });
  }
  public update(etablissement: Etablissement): Observable<Etablissement> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.put<Etablissement>(
      `${this.url}/${etablissement.id}`,
      etablissement,
      { headers: httpHeaders }
    );
  }
  public insert(etablissement: Etablissement): Observable<Etablissement> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    const o = {
      nom: etablissement.nom,
      numeroTel: etablissement.numeroTel,
      TypeEtablissement: etablissement.typeEtab,
      adresse: {
        numero: etablissement.adresse.numero,
        voie: etablissement.adresse.voie,
        cp: etablissement.adresse.cp,
        ville: etablissement.adresse.ville,
      },
      logo: etablissement.logo,
    };
    return this.http.post<Etablissement>(this.url, o, { headers: httpHeaders });
  }
}
