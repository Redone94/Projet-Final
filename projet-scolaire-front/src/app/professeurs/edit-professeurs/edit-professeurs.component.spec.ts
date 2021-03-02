import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProfesseursComponent } from './edit-professeurs.component';

describe('EditProfesseursComponent', () => {
  let component: EditProfesseursComponent;
  let fixture: ComponentFixture<EditProfesseursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditProfesseursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProfesseursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
