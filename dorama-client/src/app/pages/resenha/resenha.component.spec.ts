import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResenhaComponent } from './resenha.component';

describe('ResenhaComponent', () => {
  let component: ResenhaComponent;
  let fixture: ComponentFixture<ResenhaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResenhaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
