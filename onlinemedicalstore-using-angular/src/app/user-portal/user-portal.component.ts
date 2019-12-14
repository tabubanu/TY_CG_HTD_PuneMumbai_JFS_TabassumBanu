import { Component, OnInit } from '@angular/core';
import {  MedicinecartService } from '../medicineCart.service';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-user-portal',
  templateUrl: './user-portal.component.html',
  styleUrls: ['./user-portal.component.css']
})
export class UserPortalComponent implements OnInit {

  medicines: any[];
  constructor(private medicineCartService: MedicinecartService) {
    this.medicineCartService.getMedicine().subscribe(data => {
      console.log(data.medicineList);
      this.medicines = data.medicineList;

    }, err => {
      console.log(err);
    });
  }

  // // delete medicine from cart
  // deleteMedicineFromCart(medicine) {
  //   this.medicineCartService.deleteMedicineFromCart(medicine).subscribe(response => {
  //     console.log(response);
  //     this.medicines.splice(this.medicines.indexOf(medicine), 1);
  //     console.log('delete one medicine');
  //     // to update the table again after delete
  //     this.medicineCartService.getMedicine();
  //   }, err => {
  //     console.log(err);
  //   });
  // }



   //add Medicine To cart
   addMedicineToCart(cartForm: NgForm) {
    console.log(cartForm.value);
    this.medicineCartService.putMedicine(cartForm.value).subscribe(response => {
      console.log(response);
      cartForm.reset();
    },
      err => {
        console.log(err);
      });
  }

  ngOnInit() {
  }
}