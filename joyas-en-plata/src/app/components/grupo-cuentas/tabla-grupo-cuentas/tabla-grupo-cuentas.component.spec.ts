import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaGrupoCuentasComponent } from './tabla-grupo-cuentas.component';

describe('TablaGrupoCuentasComponent', () => {
  let component: TablaGrupoCuentasComponent;
  let fixture: ComponentFixture<TablaGrupoCuentasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablaGrupoCuentasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaGrupoCuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
