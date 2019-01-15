import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouserItemComponent } from './carouser-item.component';

describe('CarouserItemComponent', () => {
  let component: CarouserItemComponent;
  let fixture: ComponentFixture<CarouserItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarouserItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarouserItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
