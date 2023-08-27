import { Component, Input } from '@angular/core';
import { StudentCardDto } from 'src/dtos/studentCardDto';
import {HttpClient} from "@angular/common/http";
import {TeacherCardComponent} from "../teacher-card/teacher-card.component";
import {StudentCardListComponent} from "../student-card-list/student-card-list.component";
import {getXHRResponse} from "rxjs/internal/ajax/getXHRResponse";

@Component({
  selector: 'app-student-card',
  templateUrl: './student-card.component.html',
  styleUrls: ['./student-card.component.css']
})
export class StudentCardComponent {

  constructor(private httpClient: HttpClient, private studentCardList: StudentCardListComponent) {
  }


  deleteStudent(student: StudentCardDto) {
    const id = student.id;
    this.httpClient.delete("/api/students/"+ id).subscribe((response) => {
      console.log(response);
      this.studentCardList.ngOnInit();
    });
  }

  @Input()
  student: StudentCardDto= {
    id: 0,
    firstName: "",
    lastName: "",
    schoolClassDto:{},
    deleteStudent: "",
    schoolClassId: 0
  };


}
