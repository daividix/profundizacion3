import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitioComponent } from './sitio.component';

describe('SitioComponent', () => {
  let component: SitioComponent;
  let fixture: ComponentFixture<SitioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
