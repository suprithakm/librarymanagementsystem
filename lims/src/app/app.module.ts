import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminOperationComponent } from './admin-operation/admin-operation.component';
import { LibrarianOperationComponent } from './librarian-operation/librarian-operation.component';
import { StudentOperationComponent } from './student-operation/student-operation.component';
import { HttpClientModule} from '@angular/common/http';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { LibrarianHomeComponent } from './librarian-home/librarian-home.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AddbookComponent } from './addbook/addbook.component';
import { FilterPipe } from './filter.pipe';
import { CutPipe } from './custom.pipe';
import { LibrarianComponent } from './librarian/librarian.component'


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    AdminOperationComponent,
    LibrarianOperationComponent,
    StudentOperationComponent,
    AdminHomeComponent,
    LibrarianHomeComponent,
    StudentHomeComponent,
    AdduserComponent,
    AddbookComponent,
    FilterPipe,
    CutPipe,
    LibrarianComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
