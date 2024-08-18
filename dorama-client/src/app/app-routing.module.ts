import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { DoramaComponent } from './pages/dorama/dorama.component';
import { ResenhaComponent } from './pages/resenha/resenha.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'dorama/:id', component: DoramaComponent},
  {path: 'resenhas', component: ResenhaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
