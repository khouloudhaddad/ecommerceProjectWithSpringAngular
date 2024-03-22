import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import {CreateCategoryComponent} from "./components/create-category/create-category.component";
import {CreateProductComponent} from "./components/create-product/create-product.component";

const routes: Routes = [
  { path: '', component: AdminComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'category', component: CreateCategoryComponent},
  { path: 'product', component: CreateProductComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
