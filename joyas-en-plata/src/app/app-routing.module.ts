import { NgModule, ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageItemComponent} from './components/page-item/page-item.component';

const APP_ROUTES: Routes = [
// En caso que el usuario estando logueado vaya manualmente a /, hay que redirigirlo al home
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  {path: 'items/ :tipo', component: PageItemComponent},
  {path: 'anillos', component: PageItemComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  public getRoutes(): ModuleWithProviders<RouterModule> {
    const APP_ROUTING: ModuleWithProviders<RouterModule> = RouterModule.forRoot(APP_ROUTES);

    return APP_ROUTING;
  }

}
