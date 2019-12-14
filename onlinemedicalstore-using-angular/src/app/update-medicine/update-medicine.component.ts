import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from './medicine';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrls: ['./update-medicine.component.css']
})
export class UpdateMedicineComponent implements OnInit {
  medicines: any[];
  constructor(private medicineService: MedicineService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.medicineList);
      this.medicines = data.medicineList;

    }, err => {
      console.log(err);
    });
  }

  selectedMedicine: Medicine = {
    productId: null,
    productName: null,
    price: null,
    category: null,
    available: null
  };
  // deleteMedicine(form: NgForm) {
  //   this.medicineService.deleteMedicine(form.value).subscribe(response => {
  //     console.log(response);
  //     console.log('delete one medicine');
  //     form.reset();
  //     // to update the table again after delete
  //     this.medicineService.getMedicine();
  //   },
  //     err => {
  //       console.log(err);
  //     });

  // }

  selectMedicine(medicine: Medicine) {
    this.selectedMedicine = medicine;
  }

// update medicine
  submitForm(form: NgForm) {
    this.medicineService.postMedicine(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }
}
