import { Component, OnInit, Input } from '@angular/core';
import { CommonService } from '../common.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-admin-operation',
  templateUrl: './admin-operation.component.html',
  styleUrls: ['./admin-operation.component.css']
})
export class AdminOperationComponent implements OnInit {


  constructor(private service:CommonService) { }
  add(addForm:NgForm){
    if(addForm.value.type==="librarian"){
    this.service.addLibrarian(addForm.value).subscribe(resData=>{
      if(resData){
        addForm.reset();
        alert('librarian added successfully');
      }else{
        alert('librarian already exist');
      }
    })
  }else if(addForm.value.type==="student"){
    this.service.addStudent(addForm.value).subscribe(resData=>{
      if(resData){
        addForm .reset();
        alert('student added successfully');
      }else{
        alert('student already exist');
      }
    })
  }
}
  ngOnInit() {
  }

}
