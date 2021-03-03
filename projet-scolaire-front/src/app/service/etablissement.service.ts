import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etablissement } from '../model/etablissement';

@Injectable({
  providedIn: 'root'
})
export class EtablissementService {

  private url: string='http://localhost:8080/projetscolaire/api/etablissement'


  constructor(private httpClient: HttpClient) { }

  public allEtablissement(): Observable<Etablissement[]>{
    console.log(sessionStorage.getItem('tokenId'));
    return this.httpClient.get<Etablissement[]>(this.url);

  }
  public delete(id: number): Observable<void>{
    return this.httpClient.delete<void>(this.url + '/' +id);
  }
  public findById(id:number): Observable<Etablissement>{
    return this.httpClient.get<Etablissement>(this.url + '/'+id);
  }
  public update(etablissement: Etablissement): Observable<Etablissement> {
   return this.httpClient.put<Etablissement>(`${this.url}/${etablissement.id}`, etablissement);
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
  ville: etablissement.adresse.ville,
},
logo : etablissement.logo,
};
return this.httpClient.post<Etablissement>(this.url,o);
}



}
