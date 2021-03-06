import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AgmCoreModule } from '@agm/core';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule} from './material-config'; // importacion modulos angular material

import { RegisterService } from './services/register.service';

import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { SitioComponent } from './components/sitio/sitio.component';
import { SitiosCiudadesComponent } from './components/sitios-ciudades/sitios-ciudades.component';
import { BuscadorComponent } from './components/buscador/buscador.component'

import { NgbModule } from '@ng-bootstrap/ng-bootstrap'; // Modulo de Widgets Bootstrap
import { CategoriesComponent } from './components/categories/categories.component';
import { DownloadAppComponent } from './components/download-app/download-app.component';
import { FooterComponent } from './components/footer/footer.component';
import { SearcherComponent } from './components/searcher/searcher.component';
import { CategoriesResultComponent } from './components/categories-result/categories-result.component';
import { SitiosResultComponent } from './components/sitios-result/sitios-result.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SitioregistroComponent } from './components/sitioregistro/sitioregistro.component';
import { CajaComentariosComponent } from './components/caja-comentarios/caja-comentarios.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'navbar',
    component: NavbarComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    SignupComponent,
    MenuComponent,
    HomeComponent,
    SitioComponent,
    SitiosCiudadesComponent,
    CategoriesComponent,
    DownloadAppComponent,
    FooterComponent,
    SearcherComponent,
    CategoriesResultComponent,
    SitiosResultComponent,
    NavbarComponent,
    SitioregistroComponent,
    BuscadorComponent,
    CajaComentariosComponent
   ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialModule,
    NgbModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCfNb47O_qK3GpT38IuASUksgXy5S3_1bQ'
    }),
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})
  ],
  exports: [RouterModule],
  providers: [RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
