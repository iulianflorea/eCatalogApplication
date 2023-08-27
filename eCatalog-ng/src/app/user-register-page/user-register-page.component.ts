import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-register-page',
  templateUrl: './user-register-page.component.html',
  styleUrls: ['./user-register-page.component.css']
})
export class UserRegisterPageComponent {

  registerForm: FormGroup = new FormGroup({
    email: new FormControl(),
    pass: new FormControl()
  });

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  register() {
    var registerBody = {
      email: this.registerForm.value.email,
      pass: this.registerForm.value.pass
    };

    this.httpClient.post("/api/register", registerBody).subscribe(
      registered => {
        localStorage.setItem("RegisteredInUserEmail", registerBody.email);
        localStorage.setItem("RegisteredInUserPass", registerBody.pass);
        this.router.navigate(["/classes"]).then(r => r);
      },
      error => {
        alert("Ceva a mers prost");
      }
    )
  }


}
