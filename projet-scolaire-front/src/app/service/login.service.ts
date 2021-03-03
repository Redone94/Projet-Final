import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../model/login';
import { Roles } from '../model/roles.enum';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private url: string = 'http://localhost:8080/projetscolaire/api/login'
  roles : Roles;  
  
  constructor(private http: HttpClient) {}

  public auth(login: Login ): Observable<void> {
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login.login}:${login.password}`),
    });
    
    return this.http.get<void>('http://localhost:8080/projetscolaire/api/login', {
      headers: headers,
    });


  }

  public checkLogin(username: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.url}/${username}`);
  }
}

