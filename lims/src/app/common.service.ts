import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Subject } from 'rxjs';
import { Book } from './book';
import { BookRegistration } from './booksregistration';
import { BookTransaction } from './bookstransaction';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  user =  new Subject<User>();
  book = new Subject<Book> ();
  api='http://localhost:8080/';
  constructor(private http:HttpClient) { 
  }

login(login):any{
  return this.http.get<User>(`${this.api}login/${login.userId}/${login.password}`,login);
}
addUser(user){
  return this.http.post<User>(`${this.api}addUser`,user);
}
updateUser(user){
  return this.http.put<User>(`${this.api}updateUser`,user);
}
deleteUser(user){
  return this.http.delete<User>(`${this.api}deleteUser/${user.userId}`,user);
}
getAllUser():any{
  return this.http.get<User>(`${this.api}showAllUser`);
}

addBook(book){
  return this.http.post<Book>(`${this.api}addBooks`,book);
}
updateBook(book){
  return this.http.put<Book>(`${this.api}updateBooks`,book);
}
deleteBook(book){
  return this.http.delete<Book>(`${this.api}deleteBooks/${book.bookId}`,book);
}
getAllBook():any{
  return this.http.get<Book>(`${this.api}showAllBooks`);
}

getAllReqBook():any{
  return this.http.get<BookRegistration>(`${this.api}showAllRequests`);
}
getrequest(userId,book){
  return this.http.post<BookRegistration>(`${this.api}requestBook/${userId}`,book)
}
cancelRequest(id,userId){
  return this.http.delete<BookRegistration>(`${this.api}cancelRequestBook/${id}/${userId}`)
}
acceptRequest(regid){
  return this.http.get<BookTransaction>(`${this.api}acceptRequest/${regid}`)
}
getAllIssuedBooks():any{
  return this.http.get<BookTransaction>(`${this.api}showAllIssuedBooks`);
}
}
