import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professeur } from '../model/professeur';
import { Roles } from '../model/roles.enum';

@Injectable({
  providedIn: 'root'
})
export class ProfesseurService {

  private url: string='http://localhost:8080/projetscolaire/api/professeur'

  private httpHeaders: HttpHeaders;

  constructor(private httpClient: HttpClient) { 
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),

    });

  }

  public allProfesseur(): Observable<Professeur[]>{
    console.log(sessionStorage.getItem('tokenId'));
    return this.httpClient.get<Professeur[]>(this.url);

  }
  public delete(id: number): Observable<void>{
    return this.httpClient.delete<void>(this.url + '/' +id);
  }
  public findById(id:number): Observable<Professeur>{
    return this.httpClient.get<Professeur>(this.url + '/'+id);
  }
  public update(professeur: Professeur): Observable<Professeur> {
   return this.httpClient.put<Professeur>(`${this.url}/${professeur.id}`, professeur);
 }
 public insert(professeur: Professeur): Observable<Professeur>{
  const o ={
id: professeur.id,
nom: professeur.nom,
prenom:professeur.prenom,
datenaissance: professeur.datenaissance,
matiere:[
  professeur.matiere,
], 

adresse: {
numero: professeur.adresse.numero,
voie: professeur.adresse.voie,
ville:professeur.adresse.ville,
},

image: professeur.logo,

compte: {
id: professeur.compte.id,
login:professeur.compte.login,
role: professeur.compte.role,
etablissement:professeur.compte.etablissement,

}
  };
  return this.httpClient.post<Professeur>(this.url,o);
}
}
