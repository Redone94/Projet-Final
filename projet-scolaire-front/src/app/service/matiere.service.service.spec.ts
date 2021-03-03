import { TestBed } from '@angular/core/testing';

import { Matiere.ServiceService } from './matiere.service.service';

describe('Matiere.ServiceService', () => {
  let service: Matiere.ServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Matiere.ServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
