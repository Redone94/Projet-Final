import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMatieresComponent } from './edit-matieres.component';

describe('EditMatieresComponent', () => {
  let component: EditMatieresComponent;
  let fixture: ComponentFixture<EditMatieresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditMatieresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMatieresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
