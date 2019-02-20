import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CajaComentariosComponent } from './caja-comentarios.component';

describe('CajaComentariosComponent', () => {
  let component: CajaComentariosComponent;
  let fixture: ComponentFixture<CajaComentariosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CajaComentariosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CajaComentariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
