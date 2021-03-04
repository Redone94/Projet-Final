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
    'http://localhost:8080/projetscolaire/api/reset';
  roles: string;

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

  public checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.url}/${login}`);
  }
  changePassword(model: any) {
    return this.http.post(this.auth + 'changepassword', model);
  }

  resetPassword(model: any) {
    let headers = new HttpHeaders({
      changePasswordUrl: this.changePasswordUrl,
    });
    let options = { headers: headers };
    return this.http.post(this.auth + 'resetpassword', model, options);
  }
}
