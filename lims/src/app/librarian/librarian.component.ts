import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-librarian',
  templateUrl: './librarian.component.html',
  styleUrls: ['./librarian.component.css']
})
export class LibrarianComponent implements OnInit {
  allissued=[];

  constructor(private service: CommonService) {
    
    this.getIssuedBooks();
  }

  getIssuedBooks(){
    this.service.getAllIssuedBooks().subscribe(resData=>{
      console.log(resData);
      this.allissued=resData;
    })
  }
  ngOnInit() {
  }

}
