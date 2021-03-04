import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Salle } from '../model/salle';

@Injectable({
  providedIn: 'root'
})
export class SalleService {

  private url: string = 'http://localhost:8080/projetscolaire/api/salles';
  private HttpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

  public allSalle(): Observable<Salle[]> {
    return this.http.get<Salle[]>(this.url, { headers: this.HttpHeaders });
  }


    public delete(id:number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id, {
        headers: this.HttpHeaders,
      });

  }

  public update(salle: Salle): Observable<Salle> {
    return this.http.put<Salle>(`${this.url}/${salle.id}`, salle, {
      headers: this.HttpHeaders,
    });
  }

  public insert(salle: Salle): Observable<Salle> {
    const o = {
      id: salle.id,
      nom: salle.nom,
      capacite: salle.capacite,
    };
    return this.http.post<Salle>(this.url, o, { headers: this.HttpHeaders });
  }

  public findById(id:number): Observable<Salle>{
    return this.http.get<Salle>(this.url + '/'+id);
    }
}
