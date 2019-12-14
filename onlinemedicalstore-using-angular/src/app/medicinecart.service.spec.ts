import { TestBed } from '@angular/core/testing';

import { MedicinecartService } from './medicinecart.service';

describe('MedicinecartService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MedicinecartService = TestBed.get(MedicinecartService);
    expect(service).toBeTruthy();
  });
});
