import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { HeadComponent } from './components/templates/head/head.component';
import { FooterComponent } from './components/templates/footer/footer.component';
import { BodyComponent } from './components/templates/body/body.component';
import { ColumnRightComponent } from './components/templates/column-right/column-right.component';
import { ColumnMidleComponent } from './components/templates/column-midle/column-midle.component';
import { ColumnLeftComponent } from './components/templates/column-left/column-left.component';
import { PriceDisplayComponent } from './components/product/price-display/price-display.component';
import { ProductDepartmentComponent } from './components/product/product-department/product-department.component';
import { ProductImageComponent } from './components/product/product-image/product-image.component';
import { ProductListComponent } from './components/product/product-list/product-list.component';
import { ProductRowComponent } from './components/product/product-row/product-row.component';
import { PriceListComponent } from './components/price-list/price-list.component';
import { MenuPrincipalComponent } from './components/templates/menu-principal/menu-principal.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { CarouserItemComponent } from './components/carouser-item/carouser-item.component';
import { Item1Component } from './components/templates/item1/item1.component';
import { DepartmentComponent } from './components/department/department.component';
import { ArticleComponent } from './components/article/article.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';
import { ClienteService } from './services/cliente.service';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule } from '@angular/common/http';
import { Http} from '@angular/http';
import {
FormsModule,
ReactiveFormsModule
} from '@angular/forms';
import { PageItemComponent } from './components/page-item/page-item.component';
import { GrupoCuentasComponent } from './components/grupo-cuentas/grupo-cuentas/grupo-cuentas.component';
import { TablaGrupoCuentasComponent } from './components/grupo-cuentas/tabla-grupo-cuentas/tabla-grupo-cuentas.component';
import { CuentasFormComponent } from './components/cuentas/cuentas-form/cuentas-form.component';
import { CuentasTableComponent } from './components/cuentas/cuentas-table/cuentas-table.component';
@NgModule({
  declarations: [
    AppComponent,
    HeadComponent,
    FooterComponent,
    BodyComponent,
    ColumnRightComponent,
    ColumnMidleComponent,
    ColumnLeftComponent,
    PriceDisplayComponent,
    ProductDepartmentComponent,
    ProductImageComponent,
    ProductListComponent,
    ProductRowComponent,
    PriceListComponent,
    MenuPrincipalComponent,
    CarouselComponent,
    CarouserItemComponent,
    Item1Component,
    DepartmentComponent,
    ArticleComponent,
    ClienteComponent,
    ClienteListComponent,
    PageItemComponent,
    GrupoCuentasComponent,
    TablaGrupoCuentasComponent,
    CuentasFormComponent,
    CuentasTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    AppComponent,
    ClienteComponent
  ],
  providers: [
    ClienteService,
  {
      provide: Http
    }],
  bootstrap: [AppComponent]
})
export class AppModule {

}
