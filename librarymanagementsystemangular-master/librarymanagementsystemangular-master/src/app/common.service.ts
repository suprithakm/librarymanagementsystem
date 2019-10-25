import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  user =  new Subject<User>();
  api='http://localhost:8080/';
  isadd:boolean;
  constructor(private http:HttpClient) { 
  }

login(login):any{
  return this.http.post<User>(`${this.api}login`,login);
}
addLibrarian(librarian){
  return this.http.post<User>(`${this.api}addLibrarian`,librarian);
}
addStudent(student){
  return this.http.post<User>(`${this.api}addStudent`,student);
}
}
