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

  constructor(private http: HttpClient) { 
  }

  public allProfesseur(): Observable<Professeur[]>{
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.get<Professeur[]>(this.url,{ headers:httpHeaders } );

  }
  public delete(id: number): Observable<void>{
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.delete<void>(this.url + '/' +id,{ headers:httpHeaders });
  }
  public findById(id:number): Observable<Professeur>{
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.get<Professeur>(this.url + '/'+id,{ headers:httpHeaders });
  }
  public update(professeur: Professeur): Observable<Professeur> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
   return this.http.put<Professeur>(`${this.url}/${professeur.id}`, professeur,{ headers:httpHeaders });
 }
 public insert(professeur: Professeur): Observable<Professeur>{
  const httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
  });
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
cp: professeur.adresse.cp,
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
  return this.http.post<Professeur>(this.url,o,{ headers:httpHeaders });
}
}
