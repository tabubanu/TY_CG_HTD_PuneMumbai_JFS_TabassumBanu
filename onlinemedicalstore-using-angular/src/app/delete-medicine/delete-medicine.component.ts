import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { NgForm } from '@angular/forms';
import { Medicine } from '../update-medicine/medicine';

@Component({
  selector: 'app-delete-medicine',
  templateUrl: './delete-medicine.component.html',
  styleUrls: ['./delete-medicine.component.css']
})
export class DeleteMedicineComponent implements OnInit {

  medicines: any[];

  constructor(private medicineService: MedicineService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.medicineList);
      this.medicines = data.medicineList;

    }, err => {
      console.log(err);
    });
  }


  // delete medicine
  deleteMedicine(medicine) {
    this.medicineService.deleteMedicine(medicine).subscribe(response => {
      console.log(response);
      this.medicines.splice(this.medicines.indexOf(medicine), 1);
      console.log('delete one medicine');
      // to update the table again after delete
      this.medicineService.getMedicine();
    }, err => {
      console.log(err);
    });
  }


  ngOnInit() {
  }

}
