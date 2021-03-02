import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'projet-scolaire-front';
  _user :string='';
  constructor(private router: Router) {}

  public logout(){
sessionStorage.removeItem('tokenId');
sessionStorage.removeItem('login');
this._user='';
this.router.navigate(['/login']);
  }
  public user(){
    if(sessionStorage.getItem('tokenId')){
    return true;
    
    }
    return false;
  }
}
