import {
Component,
EventEmitter,
Input,
Output } from '@angular/core';

import { Product } from '../../domains/Product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  /**
* @input productList - the Product[] passed to us
*/
@Input() productList: Product[];
/**
* @output onProductSelected - outputs the current
*
Product whenever a new Product is selected
*/
@Output() onnProductSelected: EventEmitter<Product>;

/**
   *  currentProduct - local state containing
   *             the currently selected `Product`
   */
  private currentProduct: Product;

  constructor() {
    this.onnProductSelected = new EventEmitter();
  }

  clicked(product: Product): void {
    this.currentProduct = product;
    this.onnProductSelected.emit(product);
  }

  isSelected(product: Product): boolean {
    if (!product || !this.currentProduct) {
      return false;
    }
    return product.price === this.currentProduct.price;
  }

}
