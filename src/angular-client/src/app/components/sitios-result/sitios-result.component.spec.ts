import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitiosResultComponent } from './sitios-result.component';

describe('SitiosResultComponent', () => {
  let component: SitiosResultComponent;
  let fixture: ComponentFixture<SitiosResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitiosResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitiosResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
