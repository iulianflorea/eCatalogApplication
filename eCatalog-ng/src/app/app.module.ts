import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeacherCardDto } from './teacher/teacher-card-dto.component';
import { HeaderComponent } from './header/header.component';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { SchoolClassesTableComponent } from './school-classes-table/school-classes-table.component';
import {MatCardModule} from '@angular/material/card';
import { TeacherCardComponent } from './teacher-card/teacher-card.component';
import { TeacherCardListComponent } from './teacher-card-list/teacher-card-list.component';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StudentComponent } from './student/student.component';
import { StudentCardComponent } from './student-card/student-card.component';
import { StudentCardListComponent } from './student-card-list/student-card-list.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { UserLoginPageComponent } from './user-login-page/user-login-page.component';
import {CredetialsInterceptorService} from "./interceptors/credentials-interceptor.service";
import { UserRegisterPageComponent } from './user-register-page/user-register-page.component';
import { DeleteComponent } from './delete/delete.component';
import { SchoolClassesFormComponent } from './school-classes-form/school-classes-form.component';
import {MatIconModule} from "@angular/material/icon";
import { HomeComponent } from './home/home.component';
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    AppComponent,
    TeacherCardDto,
    HeaderComponent,
    SchoolClassesTableComponent,
    TeacherCardComponent,
    TeacherCardListComponent,
    TeacherFormComponent,
    StudentComponent,
    StudentCardComponent,
    StudentCardListComponent,
    StudentFormComponent,
    UserLoginPageComponent,
    UserRegisterPageComponent,
    DeleteComponent,
    SchoolClassesFormComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    HttpClientModule,
    MatTableModule,
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    FormsModule,
    MatIconModule,
    MatSelectModule,
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass:CredetialsInterceptorService
    ,multi:true}

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
