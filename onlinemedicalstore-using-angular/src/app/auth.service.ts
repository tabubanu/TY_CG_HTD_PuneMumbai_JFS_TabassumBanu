import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  api = 'http://localhost:8080/onlinemedicalstoreusingspringrest/';

  isLoggedIn() {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.registered) {
      return true;
    } else {
      return false;
    }
  }

  login(credentials): Observable<any> {
    // tslint:disable-next-line: max-line-length
    return this.http.get(`${this.api}adminUserLogin?email=${credentials.email}&password=${credentials.password}&type=${credentials.type}`, credentials);
  }

  isRegistered() {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.registered) {
      return true;
    } else {
      return false;
    }
  }

  register(credentials): Observable<any> {
    return this.http.put(`${this.api}userRegister`, credentials);
  }
}
