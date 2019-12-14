import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-add-medicine',
  templateUrl: './add-medicine.component.html',
  styleUrls: ['./add-medicine.component.css']
})
export class AddMedicineComponent implements OnInit {

  constructor(private medicineService: MedicineService) { }
  submitForm(addMedicine: NgForm) {
    console.log(addMedicine.value);
    this.medicineService.putMedicine(addMedicine.value).subscribe(response => {
      console.log(response);
      addMedicine.reset();
    },
      err => {
        console.log(err);
      });

  }
  ngOnInit() {
  }

}
