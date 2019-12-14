import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-all-medicines',
  templateUrl: './all-medicines.component.html',
  styleUrls: ['./all-medicines.component.css']
})
export class AllMedicinesComponent implements OnInit {
  medicines: any[];
  constructor(private medicineService: MedicineService) {
    this.medicineService.getMedicine().subscribe(data => {
      console.log(data.medicineList);
      this.medicines = data.medicineList;

    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
