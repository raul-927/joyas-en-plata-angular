import { TestBed } from '@angular/core/testing';

import { GrupoCuentasService } from './grupo-cuentas.service';

describe('GrupoCuentasService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GrupoCuentasService = TestBed.get(GrupoCuentasService);
    expect(service).toBeTruthy();
  });
});
