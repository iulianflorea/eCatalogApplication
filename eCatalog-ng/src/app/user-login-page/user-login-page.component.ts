import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login-page',
  templateUrl: './user-login-page.component.html',
  styleUrls: ['./user-login-page.component.css']
})
export class UserLoginPageComponent {

  loginForm : FormGroup =new FormGroup({
    email: new FormControl(),
    password: new FormControl()
  });
  constructor(private httpClient: HttpClient, private router:Router){

  }

  login() {
    var loginBody = {
      email: this.loginForm.value.email,
      pass: this.loginForm.value.password
    };

    this.httpClient.post("/api/login", loginBody).subscribe(
      successR => {
        localStorage.setItem("loggedInUserEmail", loginBody.email);
        localStorage.setItem("loggedInUserPass", loginBody.pass);
        this.router.navigate(["/home"]);
      },
      errorR => {
        alert("Ceva a mers prost");
      }
      );
  }
}
