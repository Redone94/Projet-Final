import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSallesComponent } from './edit-salles.component';

describe('EditSallesComponent', () => {
  let component: EditSallesComponent;
  let fixture: ComponentFixture<EditSallesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditSallesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSallesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
