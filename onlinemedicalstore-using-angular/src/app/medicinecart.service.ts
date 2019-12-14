import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicinecartService {

  constructor(private http: HttpClient) { }

  getMedicine() {
    return this.http.get<any>(`http://localhost:8080/onlinemedicalstoreusingspringrest/displayAllProducts`);
  }
  
  // deleteMedicineFromCart(data) : Observable<any>{
  //   return this.http.delete<any>(`http://localhost:8080/springrestparallelproject/removeMedicineCart?medicineid=${data.medicineid}`,data);
  // }

  putMedicine(data): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/onlinemedicalstoreusing/addProductinCart?userid=${data.userid}&medicineid=${data.medicineid}`, data);
  }

}
