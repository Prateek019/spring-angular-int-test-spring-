import { Component } from '@angular/core';
import { CustserviceService } from './service/custservice.service';
import { Customer } from './models/Customer.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  allCustomers:Customer[]
  statusCode:number
  size:number
  cust:Customer;
  constructor(private cService:CustserviceService){
    this.getAllCustomers();
  }
 getAllCustomers(){
    this.cService.getAllCustomers().subscribe(
      data=>this.allCustomers = data
   //   errorCode => this.statusCode =  errorCode  
      
  )
 // this.size=this.allCustomers.length    
  }
  createCustomer(){
    let cobj:Customer;
    cobj=new Customer(143, "NewCustomer", "NewAddress");
    this.cService.createCustomer(cobj)
    .then(()=>{console.log("Success");})
    .catch(()=>{console.log("Failure");})

  }
  deleteCustomer(id:number){
   console.log(id);
    this.cService.deleteCustomer(id).subscribe(
      resp=>{
        if(resp.ok)
        {
          console.log("Deleted");
        }
      }
    );
  }

  ngOnInit() {
    
    /*  this.cService.getAllCustomers().subscribe(
      data => this.allCustomers=data
    );*/
  }

}
