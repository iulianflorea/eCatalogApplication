import { TestBed } from '@angular/core/testing';

import { CredetialsInterceptorService } from '../../../../Downloads/spring-boot-3-jwt-security-main/ecatalog-app/src/app/interceptors/credentials-interceptor.service';

describe('CredetialsInterceptorService', () => {
  let service: CredetialsInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CredetialsInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
