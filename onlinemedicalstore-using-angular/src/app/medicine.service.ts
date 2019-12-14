import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medicine } from './update-medicine/medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {


  // medicines: Medicine[] = [];
  constructor(private http: HttpClient) { }

  getMedicine() {
    return this.http.get<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/displayAllMedicine`);
  }
  putMedicine(data): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/addProduct`, data);
  }

  deleteMedicine(data): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/removeProduct?productId=${data.productId}`, data);
  }
  postMedicine(data): Observable<any> {
    // tslint:disable-next-line: max-line-length
    return this.http.post<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/updateProduct?productId=${data.productId}&price=${data.price}&available=${data.available}`, data);
  }

  getUser() {
    return this.http.get<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/getAllUsers`);
  }

  deleteUser(data): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/deleteUser?id=${data.id}`, data);
  }
}









