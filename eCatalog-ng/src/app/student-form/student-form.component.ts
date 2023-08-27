import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from "@angular/router";
import {SchoolClassDto} from "../../dtos/schoolClassDto";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent {

  schoolClassIdSelected: any;
  schoolClassList: SchoolClassDto[] = [];

  studentForm: FormGroup = new FormGroup({
    firstName: new FormControl(),
    lastName: new FormControl(),
    cnp: new FormControl()
  });

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.getSchoolClassList();
  }

  saveStudent() {
    var student = {
      firstName: this.studentForm.value.firstName,
      lastName: this.studentForm.value.lastName,
      cnp: this.studentForm.value.cnp,
      schoolClassId: this.schoolClassIdSelected
    }
    this.httpClient.post("/api/students", student)
      .subscribe(response => {
        console.log(response);
        alert("Student was saved");
        this.router.navigate(["/students"])
        console.log(this.schoolClassIdSelected);
      });
  }

  getSchoolClassList() {
    this.httpClient.get("/api/school-class").subscribe((response) => {
      console.log(response);
      this.schoolClassList = response as SchoolClassDto[];
    })
  }
}
