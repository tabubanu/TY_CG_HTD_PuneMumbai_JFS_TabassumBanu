import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AllMedicinesComponent } from './all-medicines/all-medicines.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { UserComponent } from './user/user.component';
import { DeleteMedicineComponent } from './delete-medicine/delete-medicine.component';
import { RemoveUserComponent } from './remove-user/remove-user.component';
import { AddCartComponent } from './add-cart/add-cart.component';
import { UserPortalComponent } from './user-portal/user-portal.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'page-not-found', component: PageNotFoundComponent },
  { path: 'all-medicines', component: AllMedicinesComponent },
  { path: 'add-medicine', component: AddMedicineComponent},
  { path: 'update-medicine', component: UpdateMedicineComponent },
  {path: 'user', component: UserComponent},
  {path: 'delete-medicine', component: DeleteMedicineComponent},
  {path: 'remove-user', component: RemoveUserComponent},
  {path: 'add-cart', component: AddCartComponent},
  {path: 'user-portal', component: UserPortalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
