import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Login } from '../model/login';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private url: string = 'http://localhost:8080/projetscolaire/api/login';
  private changePasswordUrl: string =
    'http://localhost:8080/projetscolaire/api/compte/changePassword';
  private resetPasswordUrl: string =
    'http://localhost:8080/projetscolaire/api/login/reset';
  roles: string;

  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {}

  public auth(login: Login): Observable<Login> {
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login.login}:${login.password}`),
    });

    return this.http.get<Login>(
      'http://localhost:8080/projetscolaire/api/login',
      {
        headers: headers,
      }
    );
  }

  public checkLogin(login: string): Observable<Login> {
    return this.http.get<Login>(`${this.url}/${login}`);
  }

  changePassword(model: any, password: string) {
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.put<Login>(
      `${this.changePasswordUrl}/${password}`,
      model,
      { headers: httpHeaders }
    );
  }

  resetPassword(model: any, o: object) {
    return this.http.post(this.resetPasswordUrl, o, model);
  }
}
