import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AdminGuardService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    if (sessionStorage.getItem('tokenId')) {
      return true;
    }
    return false;
  }
}
