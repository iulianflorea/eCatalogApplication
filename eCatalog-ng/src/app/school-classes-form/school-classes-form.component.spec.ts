import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolClassesFormComponent } from './school-classes-form.component';

describe('SchoolClassesFormComponent', () => {
  let component: SchoolClassesFormComponent;
  let fixture: ComponentFixture<SchoolClassesFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchoolClassesFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SchoolClassesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
