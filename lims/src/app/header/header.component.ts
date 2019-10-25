import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {
  @Input() public islibrarianlogin: boolean;
  @Input() public isadminlogin: boolean;
  @Input() public isstudentlogin: boolean;
  @Input() public homeclicked: boolean;
  constructor(private router:Router) { }
 
   logout(){
    this.router.navigateByUrl('login')
  }

  add(){
   const isadd=true;
  }
  ngOnInit() {
  }

}
