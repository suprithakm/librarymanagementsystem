import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-librarian-home',
  templateUrl: './librarian-home.component.html',
  styleUrls: ['./librarian-home.component.css']
})
export class LibrarianHomeComponent implements OnInit {
allreq:[]
request=false;
  constructor(private service: CommonService) {
    this.callGetBookRegData();
  }


  callGetBookRegData() {
    this.service.getAllReqBook().subscribe(resData => {
      console.log(resData);
      this.allreq = resData;
    });

  }

  acceptRequest(regid){
    this.service.acceptRequest(regid).subscribe(resData=>{
      console.log(resData);
      alert('book is issued')
      this.request=true;

    })
  }
  

  ngOnInit() {
  }

}
