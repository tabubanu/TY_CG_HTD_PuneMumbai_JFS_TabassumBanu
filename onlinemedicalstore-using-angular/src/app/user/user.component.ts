import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: any[];
  constructor(private medicineService: MedicineService) {
    this.medicineService.getUser().subscribe(data => {
      console.log(data.userList);
      this.users = data.userList;

    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
