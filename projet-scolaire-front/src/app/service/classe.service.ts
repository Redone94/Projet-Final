
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Classe } from '../model/classe';

@Injectable({
  providedIn: 'root'
})
export class ClasseService {

  private url: string = 'http://localhost:8080/projetscolaire/api/classes';

  private HttpHeaders: HttpHeaders;
  constructor(private http: HttpClient) {

  }

  public allClasse(): Observable<Classe[]> {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
      });
    return this.http.get<Classe[]>(this.url, { headers: httpHeaders });
  }


    public delete(id:number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id, {headers: this.HttpHeaders, });
  }

  public update(classe: Classe): Observable<Classe> {
    return this.http.put<Classe>(`${this.url}/${classe.id}`, classe, {
      headers: this.HttpHeaders,
    });
  }

  public insert(classe: Classe): Observable<Classe> {
    const o = {
      id: classe.id,
      nom: classe.nom,
      profPrincipal: classe.profPrincipal,
    };
    return this.http.post<Classe>(this.url, o, { headers: this.HttpHeaders });
  }

  public findById(id:number): Observable<Classe>{
    return this.http.get<Classe>(this.url + '/'+id);
    }
}
