import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carouser-item',
  templateUrl: './carouser-item.component.html',
  styleUrls: ['./carouser-item.component.css']
})
export class CarouserItemComponent implements OnInit {

  imagenes: number[];

  constructor() {
    this.imagenes = [7];
  }

  ngOnInit() {
  }

}
