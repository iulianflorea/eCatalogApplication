import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { TeacherCardDto } from 'src/dtos/teacherCardDto';
import {TeacherFormComponent} from "../teacher-form/teacher-form.component";
import {TeacherCardComponent} from "../teacher-card/teacher-card.component";

@Component({
  selector: 'app-teacher-card-list',
  templateUrl: './teacher-card-list.component.html',
  styleUrls: ['./teacher-card-list.component.css']
})
export class TeacherCardListComponent {

  teacherCardList: TeacherCardDto[]=[];

  constructor (private httpClient:HttpClient){}

ngOnInit(): void{
  this.httpClient.get("/api/teachers/teachers_cards").subscribe(
    response=>{
      console.log(response);
      this.teacherCardList=response as TeacherCardDto[];
    }
  );
}

}
