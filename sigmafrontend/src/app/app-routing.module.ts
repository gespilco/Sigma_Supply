import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeLayoutComponent } from './layouts/home-layout/home-layout.component';
import { AsignarTecnicoOrdenComponent } from './pages/asignar-tecnico-orden/asignar-tecnico-orden.component';
import { GenerarHojaRutaComponent } from './pages/generar-hoja-ruta/generar-hoja-ruta.component';

const routes: Routes = [
  {
    path: '', component: HomeLayoutComponent,
    children:[
      {path: '', redirectTo: '/asignar-tecnico-orden', pathMatch: 'full'},
      {path: 'asignar-tecnico-orden', component: AsignarTecnicoOrdenComponent},
      {path: 'generar-hoja-ruta', component: GenerarHojaRutaComponent}
    ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
