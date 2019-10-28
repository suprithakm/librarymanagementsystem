import { Component, OnInit, Input } from '@angular/core';
import { CommonService } from '../common.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-admin-operation',
  templateUrl: './admin-operation.component.html',
  styleUrls: ['./admin-operation.component.css']
})
export class AdminOperationComponent implements OnInit {


  
  selectedUser={
    userId:null,
    userName:null,
    emailId:null,
    password:null,
    type :null,
  }
allusers=[];


  constructor(private service:CommonService ) 
    {
      this.callGetUserData();
    }
   

   selectUser(users) {
    this.selectedUser = users;
  }

   callGetUserData(){
  this.service.getAllUser().subscribe(resData =>{
    console.log(resData);
   this.allusers=resData;
  
    });

 }

 update(updateForm: NgForm){
  this.service.updateUser(updateForm.value)
  .subscribe(resData=>{
    if(resData){
    console.log(resData);
    updateForm.reset();
    alert("updated successfully");
    this.callGetUserData();
    }else{
      alert('updation failed');
    }
  }, err=>{
    console.log(err);
  });
    }
  
    delete(users) {
      console.log(users);
      this.service.deleteUser(users).subscribe(resData=> {
        if(resData){
        console.log(resData);
        alert('deleted successfully')
        this.callGetUserData();
        }else{
          console.log(resData)
          alert('deletion failed')
        }
      }, err=> {
        console.log(err);
      });
    }


  ngOnInit() {
  }

}
