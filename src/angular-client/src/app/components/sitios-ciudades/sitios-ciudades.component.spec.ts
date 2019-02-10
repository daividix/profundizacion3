import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitiosCiudadesComponent } from './sitios-ciudades.component';

describe('SitiosCiudadesComponent', () => {
  let component: SitiosCiudadesComponent;
  let fixture: ComponentFixture<SitiosCiudadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitiosCiudadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitiosCiudadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
