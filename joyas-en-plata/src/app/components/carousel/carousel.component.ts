import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  imagenes: number[];
  constructor() {

  }
  ngOnInit() {
    this.imagenes = [1, 2, 3, 4, 5, 6, 7];
    this.renderImages();
  }

  public renderImages(): number[] {
   this.imagenes.forEach( resultado => {
     console.log('resultado: ' + resultado);
   });

   return this.imagenes;
  }

}
