import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {TeacherCardDto} from "../teacher/teacher-card-dto.component";
import {coerceStringArray} from "@angular/cdk/coercion";
import {TeacherCardListComponent} from "../teacher-card-list/teacher-card-list.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-teacher-form',
  templateUrl: './teacher-form.component.html',
  styleUrls: ['./teacher-form.component.css']
})

export class TeacherFormComponent {

  teacherForm: FormGroup = new FormGroup({
    firstName: new FormControl(),
    lastName: new FormControl(),
    cnp: new FormControl(),
    subject: new FormControl(),
    salary: new FormControl(),
    profilePicture: new FormControl()
  });
  constructor(private httpClient: HttpClient, private router: Router){
  }

  saveTeacher(){
    var teacher = {
      firstName: this.teacherForm.value.firstName,
      lastName: this.teacherForm.value.lastName,
      cnp: this.teacherForm.value.cnp,
      subject: this.teacherForm.value.subject,
      salary: this.teacherForm.value.salary,
      profilePicture: this.teacherForm.value.profilePicture

    }
    this.httpClient.post("/api/teachers",teacher)
    .subscribe(response =>{console.log(response);
      alert("Teacher was saved");
      this.router.navigate(["/teachers"]);
    });
  }



}









