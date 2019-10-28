import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';
import{map} from'rxjs/operators'

@Component({
  selector: 'app-student-operation',
  templateUrl: './student-operation.component.html',
  styleUrls: ['./student-operation.component.css']
})
export class StudentOperationComponent implements OnInit {

  allbooks=[];
  request=false;
  id:string

  searchValue:String;

  constructor(private service:CommonService ) 
    {this.callGetBookData();
    }
   

   callGetBookData(){
  this.service.getAllBook().subscribe(data=>{
      this.allbooks=data;
      console.log(this.allbooks);

    })
  }

  requestForBook(books){
    this.service.getrequest(localStorage.getItem('token'),books).subscribe(data=>{
      if(data!=null){
        this.request=true;
      console.log(data);
      localStorage.setItem('registerId',data.registrationId)
      this.id=data.bookId;
      alert('request sent')
      }else{
        alert('this book is not available')
      }

    })
  }
  
  cancel(){
   this.service.cancelRequest( localStorage.getItem('registerId'),localStorage.getItem('token')).subscribe(resData=>{
     console.log(resData)
     this.id=null;
   })

  }
 


  ngOnInit() {
  }

}
