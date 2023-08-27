import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SchoolClassesTableComponent } from './school-classes-table/school-classes-table.component';
import { TeacherCardListComponent } from './teacher-card-list/teacher-card-list.component';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';
import { StudentCardListComponent } from './student-card-list/student-card-list.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { UserLoginPageComponent } from './user-login-page/user-login-page.component';
import {HeaderComponent} from "./header/header.component";
import {UserRegisterPageComponent} from "./user-register-page/user-register-page.component";
import {AppComponent} from "./app.component";
import {DeleteComponent} from "./delete/delete.component";
import {SchoolClassesFormComponent} from "./school-classes-form/school-classes-form.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path:'classes',component:SchoolClassesTableComponent},
  {path:'teachers',component:TeacherCardListComponent},
  {path:'new-teacher',component:TeacherFormComponent},
  {path:'students',component:StudentCardListComponent},
  {path:'new-student',component:StudentFormComponent},
  {path:'login',component:UserLoginPageComponent},
  {path: "header", component:HeaderComponent},
  {path: "register", component:UserRegisterPageComponent},
  {path: "app", component:AppComponent},
  {path: "delete-teacher", component:DeleteComponent},
  {path: "add-classes", component: SchoolClassesFormComponent},
  {path: "home" , component: HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
