import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root',
})
export class ResetService {
  private httpHeaders: HttpHeaders;
  private changePasswordUrl: string =
    'http://localhost:8080/projetscolaire/api/compte/changePasswordreset';
  constructor(private http: HttpClient) {}

  changePassword(password: string, login: string) {
    const o = { password: password, login: login };
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
    return this.http.put<Login>(`${this.changePasswordUrl}`, o, {
      headers: httpHeaders,
    });
  }
}
