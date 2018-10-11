import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http'
import {HttpParams} from '@angular/common/http'
import { Customer } from '../models/Customer.model';
import { Observable } from 'rxjs';
//import 'rxjs-compat/add/operator/map';

//import {map } from 'rxjs/operators';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable({
  providedIn: 'root'
})
export class CustserviceService {

  getUrl:string
  createCustomerUrl:string
  deleteCustomerUrl:string

  constructor(private http:Http) {
    this.getUrl="http://localhost:9009/getall";
    this.createCustomerUrl="http://localhost:9009/create"
    this.deleteCustomerUrl="http://localhost:9009/delete"
  }
  
  
  
  getAllCustomers(): Observable<Customer[]>{
    
   return this.http.get(this.getUrl)
     .map(this.extractData)
    .catch(this.handleError);

      
  }
   /*   return this.http.get(this.getUrl).pipe(
        map(data => data.json())
      );
  }*/
  private extractData(res: Response){
   return res.json();

  }
  private handleError(error: Response){
  return  "Error Aa gya"+error.status;
  }

  createCustomer(cust: Customer):Promise<Customer>{
  
    let headers = new Headers({'content-Type' : 'application/json'});
    let options = new RequestOptions({headers:headers});
    
    return this.http.post(this.createCustomerUrl, cust, options).toPromise()
    .then(this.extractCustData)
    .catch(this.handleErrorPromise);

  }
  extractCustData(res: Response){
    let body =  res.json();
    return body;
  }
  handleErrorPromise(error: Response){
    console.log("error message" + error.status)
    return Promise.reject("error message" + error.status);
  }

  deleteCustomer(id:number): Observable<Response>{

    console.log("In service "+id);
    this.deleteCustomerUrl=this.deleteCustomerUrl+"/"+id;
    console.log(this.deleteCustomerUrl);
    return this.http.delete(this.deleteCustomerUrl)


    //this.deleteCustomer=this.deleteCustomer;
  }

}
//for delete - this.http.delete