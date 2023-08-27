import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';
import {SchoolClassDto} from 'src/dtos/schoolClassDto';


const SCHOOL_CLASSES: SchoolClassDto[] = [];

@Component({
  selector: 'app-school-classes-table',
  templateUrl: './school-classes-table.component.html',
  styleUrls: ['./school-classes-table.component.css']
})
export class SchoolClassesTableComponent {
  partialColumns = ['id', 'normalizedSchoolClassName', 'startYear', 'classLevel', 'delete']
  dataSource: SchoolClassDto[] = [];

  constructor(private httpClient: HttpClient) {

  }

  ngOnInit(): void {
    this.httpClient.get("/api/school-class").subscribe(response => {
      console.log(response);
      this.dataSource = response as SchoolClassDto[];
    })
  }

  delete(schoolClass: SchoolClassDto): void {
    const id = schoolClass.id
  this.httpClient.delete("/api/school-class/" + id).subscribe((response) => {
    console.log(response);
    this.ngOnInit();
  })
  }

  protected readonly SchoolClassDto = SchoolClassDto;
}

