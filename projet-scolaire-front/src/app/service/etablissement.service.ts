import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etablissement } from '../model/etablissement';

@Injectable({
  providedIn: 'root'
})
export class EtablissementService {

  private url: string='http://localhost:8080/projetscolaire/api/etablissement'


  constructor(private http: HttpClient) { }


  public allEtablissement(): Observable<Etablissement[]>{
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
      });
    console.log(sessionStorage.getItem('tokenId'));
    return this.http.get<Etablissement[]>(this.url, {headers: httpHeaders} );

  }
  public delete(id: number): Observable<void>{
    return this.http.delete<void>(this.url + '/' +id);
  }
  public findById(id:number): Observable<Etablissement>{
    return this.http.get<Etablissement>(this.url + '/'+id);
  }
  public update(etablissement: Etablissement): Observable<Etablissement> {
   return this.http.put<Etablissement>(`${this.url}/${etablissement.id}`, etablissement);
 }
 public insert(etablissement: Etablissement): Observable<Etablissement>{
  const o ={
    id: etablissement.id,
    nom: etablissement.nom,
    numero: etablissement.numeroTel,
TypeEtablissement: etablissement.typeEtab,
adresse: {
  numero: etablissement.adresse.numero,
  voie: etablissement.adresse.voie,
  cp: etablissement.adresse.cp,
  ville: etablissement.adresse.ville,
},
logo : etablissement.logo,
};
return this.http.post<Etablissement>(this.url,o);
}



}
