import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../common.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLoading = false;
  isAdminLogin = false;
  isLibrarianLogin = false;
  isStudentLogin = false;
  isLogin = false;

  constructor(private service: CommonService, private router: Router) { }

  login(loginForm: NgForm) {
    this.service.login(loginForm.value)
      .subscribe(resData => {
        if (resData != null) {
          this.isLoading = true;
          if (resData.type === 'admin') {
            alert(' admin login successful');
            this.isAdminLogin = true;
            loginForm.reset();
            localStorage.setItem('token', resData.userId)
            this.router.navigateByUrl('/admin-home')
          }
          else if (resData.type === 'librarian') {
            alert(' librarian login successfull');
            this.isLibrarianLogin = true;
            loginForm.reset();
            localStorage.setItem('token', resData.userId)
            this.router.navigateByUrl('/librarian-home')
          }
          else if (resData.type === 'student') {
            alert('student login successfull');
            this.isStudentLogin = true;
            loginForm.reset();
            localStorage.setItem('token', resData.userId)
            this.router.navigateByUrl('/student-home')
          }
        } else {
          alert("invalid id/password");
          loginForm.reset();
        }


      });
  }


  ngOnInit() {
  }

}
