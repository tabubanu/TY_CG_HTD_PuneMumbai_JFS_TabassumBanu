import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: string = null;

  constructor(private auth: AuthService, public route: Router) { }

  login(form: NgForm) {
    console.log(form.value);
   // this.error = null;
    this.auth.login(form.value).subscribe(res => {
      console.log(res);
      if (res && res.statusCode === 201) {
        const user = JSON.stringify(res.user);
        localStorage.setItem('user', user);
        this.route.navigateByUrl('/');
        form.reset();
      }
    }, err => {
      console.log(err);
      this.error = err.error.message;
    });
  }

  ngOnInit() {
  }

}
