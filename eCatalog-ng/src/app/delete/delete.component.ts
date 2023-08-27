import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";
import {StudentCardDto} from "../../dtos/studentCardDto";
import {StudentCardComponent} from "../student-card/student-card.component";
import {TeacherCardComponent} from "../teacher-card/teacher-card.component";


@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent {

  deleteForm: FormGroup = new FormGroup({
    cnp: new FormControl()
  })

  constructor(private httpClient: HttpClient) {
  }



  deletetTeacherByCnp() {
    const cnpValue = this.deleteForm.value.cnp;


    this.httpClient.delete("/api/teachers",cnpValue).subscribe(
      response => {
        console.log(response);
        console.log("asta e CNP" + cnpValue);
      }
    )
  }


}
