import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-librarian-operation',
  templateUrl: './librarian-operation.component.html',
  styleUrls: ['./librarian-operation.component.css']
})
export class LibrarianOperationComponent implements OnInit {


  selectedBook = {
    bookId: null,
    bookName: null,
    author1: null,
    author2: null,
    yearOfPublication: null,
  }
  allbooks = [];

  allissued=[];

  constructor(private service: CommonService) {
    this.callGetBookData();
    this.getIssuedBooks();
  }


  selectBook(books) {
    this.selectedBook = books;
  }

  getIssuedBooks(){
    this.service.getAllIssuedBooks().subscribe(resData=>{
      console.log(resData);
      this.allissued=resData;
    })
  }

  callGetBookData() {
    this.service.getAllBook().subscribe(resData => {
      console.log(resData);
      this.allbooks = resData;

    });

  }

  update(updateForm: NgForm) {
    this.service.updateBook(updateForm.value)
      .subscribe(resData => {
        if (resData) {
          console.log(resData);
          updateForm.reset();
          alert("updated successfully");
          this.callGetBookData();
        } else {
          alert('updation failed');
        }
      }, err => {
        console.log(err);
      });
  }

  delete(books) {
    console.log(books);
    this.service.deleteBook(books).subscribe(resData => {
      if (resData) {
        console.log(resData);
        alert('deleted successfully')
        this.callGetBookData();
      } else {
        console.log(resData)
        alert('deletion failed')
      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
