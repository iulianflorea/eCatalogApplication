import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';
import {StudentCardDto} from 'src/dtos/studentCardDto';

@Component({
  selector: 'app-student-card-list',
  templateUrl: './student-card-list.component.html',
  styleUrls: ['./student-card-list.component.css']
})
export class StudentCardListComponent {

  studentCardList: StudentCardDto[] = [];

  constructor(private httpClient: HttpClient) {
  }


  ngOnInit(): void {
    this.httpClient.get("/api/students/students-cards")
      .subscribe(response => {
          this.studentCardList = response as StudentCardDto[];
        }
      );
  }


}

