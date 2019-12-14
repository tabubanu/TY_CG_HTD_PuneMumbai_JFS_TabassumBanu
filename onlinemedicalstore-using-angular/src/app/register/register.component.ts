import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  error: string = null;
  constructor(private auth: AuthService) { }

  register(registerForm: NgForm) {
    console.log(registerForm.value);
    this.auth.register(registerForm.value).subscribe(response => {
      console.log(response);
      registerForm.reset();
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
