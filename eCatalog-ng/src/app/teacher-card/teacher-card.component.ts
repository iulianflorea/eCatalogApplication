import {HttpClient} from '@angular/common/http';
import {Component, Input} from '@angular/core';
import {TeacherCardDto} from 'src/dtos/teacherCardDto';
import {TeacherCardListComponent} from "../teacher-card-list/teacher-card-list.component";

@Component({
  selector: 'app-teacher-card',
  templateUrl: './teacher-card.component.html',
  styleUrls: ['./teacher-card.component.css']
})
export class TeacherCardComponent {

  constructor(private httpClient: HttpClient, private teacherCardList: TeacherCardListComponent) {
  }

  deleteTeacher(teacher: TeacherCardDto) {
    const id = teacher.id;
    this.httpClient.delete("/api/teachers/" + id).subscribe((response) => {
      console.log(response);
      this.teacherCardList.ngOnInit();
    });
  }
  @Input()
  teacher: TeacherCardDto = {
    id: 0,
    firstName: "",
    lastName: "",
    subject: "",
    profilePicture: ""
  };



}

