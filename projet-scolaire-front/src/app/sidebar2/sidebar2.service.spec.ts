import { TestBed } from '@angular/core/testing';

import { Sidebar2Service } from './sidebar2.service';

describe('Sidebar2Service', () => {
  let service: Sidebar2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Sidebar2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
