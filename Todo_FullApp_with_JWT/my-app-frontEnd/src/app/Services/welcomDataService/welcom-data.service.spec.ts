import { TestBed } from '@angular/core/testing';

import { WelcomDataService } from './welcom-data.service';

describe('WelcomDataService', () => {
  let service: WelcomDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WelcomDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
