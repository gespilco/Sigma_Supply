import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeLayoutComponent } from './layouts/home-layout/home-layout.component';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from './material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';
import { NgSelectModule } from '@ng-select/ng-select';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { DxSelectBoxModule,
  DxTextBoxModule,
  DxTemplateModule } from 'devextreme-angular';
import { Funciones } from './_shared/funciones';
import { TextMaskModule } from 'angular2-text-mask';
import { AsignarTecnicoOrdenComponent } from './pages/asignar-tecnico-orden/asignar-tecnico-orden.component';
import { ModalAsignarTecnicoComponent } from './pages/asignar-tecnico-orden/modal-asignar-tecnico/modal-asignar-tecnico.component';
import { GenerarHojaRutaComponent } from './pages/generar-hoja-ruta/generar-hoja-ruta.component';
import { ModalGenerarHojaRutaComponent } from './pages/generar-hoja-ruta/modal-generar-hoja-ruta/modal-generar-hoja-ruta.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeLayoutComponent,
    AsignarTecnicoOrdenComponent,
    ModalAsignarTecnicoComponent,
    GenerarHojaRutaComponent,
    ModalGenerarHojaRutaComponent
  ],
  imports: [
    BrowserModule,
    PerfectScrollbarModule,
    AppRoutingModule,
    FormsModule,
    NgSelectModule,
    MaterialModule,
    HttpClientModule,
    ModalModule.forRoot(),
    AngularFontAwesomeModule,
    DxSelectBoxModule,
    DxTextBoxModule,
    DxTemplateModule,
    TextMaskModule
  ],
  entryComponents: [ModalAsignarTecnicoComponent, ModalGenerarHojaRutaComponent],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'ES'},
    Funciones
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
