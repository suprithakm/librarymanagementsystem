import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminOperationComponent } from './admin-operation/admin-operation.component';
import { LibrarianOperationComponent } from './librarian-operation/librarian-operation.component';
import { StudentOperationComponent } from './student-operation/student-operation.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { LibrarianHomeComponent } from './librarian-home/librarian-home.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { HeaderComponent } from './header/header.component';


const routes: Routes = [
{path:'',component:HeaderComponent},
{path:'home',component:HomeComponent},
{path:'login',component:LoginComponent},
{path:'admin-operation',component:AdminOperationComponent},
{path:'librarian-operation',component:LibrarianOperationComponent},
{path:'student-operation',component:StudentOperationComponent},
{path:'admin-home',component:AdminHomeComponent},
{path:'librarian-home',component:LibrarianHomeComponent},
{path:'student-home',component:StudentHomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
