import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitioregistroComponent } from './sitioregistro.component';

describe('SitioregistroComponent', () => {
  let component: SitioregistroComponent;
  let fixture: ComponentFixture<SitioregistroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitioregistroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitioregistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
