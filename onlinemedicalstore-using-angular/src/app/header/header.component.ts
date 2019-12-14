import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGuard } from '../auth.guard';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private auth: AuthGuard) { }
  isUser() {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.type === 'user') {
      return true;
     } else {
       return false;
     }
  }

  isAdmin() {
    const adminDetails = JSON.parse(localStorage.getItem('user'));
    if (adminDetails && adminDetails.type === 'admin') {
      return true;
     } else {
       return false;
     }
  }
// isLoggedIn() {
//   const user = JSON.parse(localStorage.getItem('user'));
//   if (user) {
//     return true;
//    } else {
//      return false;
//    }
// }

// isLoggedIn() {
//   const adminDetails = JSON.parse(localStorage.getItem('admin'));
//   if (adminDetails) {
//     return true;
//    } else {
//      return false;
//    }
// }

logout() {
  localStorage.removeItem('user');
  this.router.navigateByUrl('/login');
}
  ngOnInit() {
  }

}
