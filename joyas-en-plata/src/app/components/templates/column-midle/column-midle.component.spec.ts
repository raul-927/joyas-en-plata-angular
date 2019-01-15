import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnMidleComponent } from './column-midle.component';

describe('ColumnMidleComponent', () => {
  let component: ColumnMidleComponent;
  let fixture: ComponentFixture<ColumnMidleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColumnMidleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColumnMidleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
