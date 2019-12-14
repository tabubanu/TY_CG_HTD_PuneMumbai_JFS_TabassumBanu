import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AllMedicinesComponent } from './all-medicines/all-medicines.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { UserComponent } from './user/user.component';
import { DeleteMedicineComponent } from './delete-medicine/delete-medicine.component';
import { RemoveUserComponent } from './remove-user/remove-user.component';
import { AddCartComponent } from './add-cart/add-cart.component';
import { UserPortalComponent } from './user-portal/user-portal.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    PageNotFoundComponent,
    AllMedicinesComponent,
    AddMedicineComponent,
    UpdateMedicineComponent,
    UserComponent,
    DeleteMedicineComponent,
    RemoveUserComponent,
    AddCartComponent,
    UserPortalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
