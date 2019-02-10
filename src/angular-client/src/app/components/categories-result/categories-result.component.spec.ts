import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriesResultComponent } from './categories-result.component';

describe('CategoriesResultComponent', () => {
  let component: CategoriesResultComponent;
  let fixture: ComponentFixture<CategoriesResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoriesResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoriesResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
