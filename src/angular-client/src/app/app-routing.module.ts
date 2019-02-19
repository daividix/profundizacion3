import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SitioComponent } from './components/sitio/sitio.component';
import { CategoriesResultComponent } from './components/categories-result/categories-result.component';
import { SitiosResultComponent } from './components/sitios-result/sitios-result.component';
import { SitioregistroComponent} from './components/sitioregistro/sitioregistro.component';

const routes: Routes = [
  { path: '', component: HomeComponent, runGuardsAndResolvers: 'always' },
  { path: 'sitioregistro', component: SitioregistroComponent},
  { path: 'sitio/:id', component: SitioComponent },
  { path: 'categories-result/:id', component: CategoriesResultComponent },
  { path: 'sitios-result', component: SitiosResultComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
