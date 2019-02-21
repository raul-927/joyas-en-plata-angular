import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CuentasTableComponent } from './cuentas-table.component';

describe('CuentasTableComponent', () => {
  let component: CuentasTableComponent;
  let fixture: ComponentFixture<CuentasTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CuentasTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CuentasTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
