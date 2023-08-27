import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {SchoolClassesTableComponent} from "../school-classes-table/school-classes-table.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-school-classes-form',
  templateUrl: './school-classes-form.component.html',
  styleUrls: ['./school-classes-form.component.css']
})
export class SchoolClassesFormComponent {

  schoolClassForm: FormGroup = new FormGroup({
    name: new FormControl(),
    startYear: new FormControl(),
    classLevel: new FormControl()
  });

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  addSchoolClass() {
    var schoolClass = {
      name: this.schoolClassForm.value.name,
      startYear: this.schoolClassForm.value.startYear,
      classLevel: this.schoolClassForm.value.classLevel
    }

    this.httpClient.post("/api/school-class", schoolClass).subscribe(
      response => {
        console.log(response);
        alert("School Class was saved");
        this.router.navigate(["/classes"]);
      }
    )
  }


}
