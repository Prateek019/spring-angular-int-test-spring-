import { TestBed, inject } from '@angular/core/testing';

import { CustserviceService } from './custservice.service';

describe('CustserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustserviceService]
    });
  });

  it('should be created', inject([CustserviceService], (service: CustserviceService) => {
    expect(service).toBeTruthy();
  }));
});
