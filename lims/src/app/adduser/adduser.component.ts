import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  constructor(private service:CommonService) { }
  
  add(addForm:NgForm){
   console.log(localStorage.getItem('token'));
    this.service.addUser(addForm.value).subscribe(resData=>{
      if(resData){
        addForm.reset();
        alert('user added successfully');
      }else{
        alert('user id already exist');
      }
    })
  }

  ngOnInit() {
  }

}
