import {PageItemComponent} from '../components/page-item/page-item.component';
import { ArticleComponent } from '../components/article/article.component';
import { ClienteComponent } from '../components/cliente/cliente.component';
import { ClienteListComponent } from '../components/cliente-list/cliente-list.component';
import { DepartmentComponent } from '../components/department/department.component';
import { PriceDisplayComponent } from '../components/product/price-display/price-display.component';
import { PriceListComponent } from '../components/price-list/price-list.component';
import { ProductDepartmentComponent } from '../components/product/product-department/product-department.component';
import { ProductImageComponent } from '../components/product/product-image/product-image.component';
import { ProductListComponent } from '../components/product/product-list/product-list.component';
import { ProductRowComponent } from '../components/product/product-row/product-row.component';
import { BodyComponent } from '../components/templates/body/body.component';
import { ColumnLeftComponent } from '../components/templates/column-left/column-left.component';
import { ColumnRightComponent } from '../components/templates/column-right/column-right.component';
import { ColumnMidleComponent } from '../components/templates/column-midle/column-midle.component';
import { FooterComponent } from '../components/templates/footer/footer.component';
import { HeadComponent } from '../components/templates/head/head.component';
import { MenuPrincipalComponent } from '../components/templates/menu-principal/menu-principal.component';
export class ComponentRegistry {

    componentRegistry = {
        'app-page-item'         : PageItemComponent,
        'app-article'           : ArticleComponent,
        'app-cliente'           : ClienteComponent,
        'app-cliente-list'      : ClienteListComponent,
        'app-deparment'         : DepartmentComponent,
        'app-price-display'     : PriceDisplayComponent,
        'app-price-list'        : PriceListComponent,
        'app-product-department': ProductDepartmentComponent,
        'app-product-image'     : ProductImageComponent,
        'app-product-list'      : ProductListComponent,
        'app-product-row'       : ProductRowComponent,
        'app-body'              : BodyComponent,
        'app-column-left'       : ColumnLeftComponent,
        'app-column-right'      : ColumnRightComponent,
        'app-column-midle'      : ColumnMidleComponent,
        'app-footer'            : FooterComponent,
        'app-head'              : HeadComponent,
        'app-menu-principal'    : MenuPrincipalComponent
    };

    public getCR(tag: string) {
        return this.componentRegistry[tag];
    }
}
