import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../model/matiere';

@Injectable({
  providedIn: 'root'
})
export class matiereService {

  private url: string = 'http://localhost:8080/projetscolaire/api/matieres';
  private HttpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

  public allMatiere(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(this.url, { headers: this.HttpHeaders });
  }


    public delete(id:number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id, {
        headers: this.HttpHeaders,
      });

  }

  public update(salle: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`${this.url}/${salle.id}`, salle, {
      headers: this.HttpHeaders,
    });
  }

  public insert(matiere: Matiere): Observable<Matiere> {
    const o = {
      id: matiere.id,
      nom: matiere.nom,
      couleur: matiere.couleur,
    };
    return this.http.post<Matiere>(this.url, o, { headers: this.HttpHeaders });
  }

  public findById(id:number): Observable<Matiere>{
    return this.http.get<Matiere>(this.url + '/'+id, { headers: this.HttpHeaders });
    }
}
