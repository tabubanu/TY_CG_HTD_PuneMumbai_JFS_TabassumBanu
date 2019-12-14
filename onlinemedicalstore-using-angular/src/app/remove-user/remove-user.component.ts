import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-remove-user',
  templateUrl: './remove-user.component.html',
  styleUrls: ['./remove-user.component.css']
})
export class RemoveUserComponent implements OnInit {
  users: [];
  constructor(private medicineService: MedicineService) {
    this.medicineService.getUser().subscribe(data => {
      console.log(data.userList);
      this.users = data.userList;

    }, err => {
      console.log(err);
    });
  }
// delete user by admin
deleteUser(user) {
  this.medicineService.deleteUser(user).subscribe(response => {
    console.log(response);
    // this.users.splice(this.users.indexOf(), 1);
    console.log('delete one user');
    // to update the table again after delete
    this.medicineService.getMedicine();
  }, err => {
    console.log(err);
  });
}
  ngOnInit() {
  }

}
