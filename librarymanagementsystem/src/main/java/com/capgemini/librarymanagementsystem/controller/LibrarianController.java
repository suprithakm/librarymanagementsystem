package com.capgemini.librarymanagementsystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;
import com.capgemini.librarymanagementsystem.service.LibrarianService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*",allowCredentials="true")
public class LibrarianController {

	@Autowired
	private LibrarianService librarian;


	@PostMapping("addBooks")
	public boolean addBook(@RequestBody BooksInventory book) {
		try {
			if(librarian.addBooks(book)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return false;
	}//end of addBooks

	@PutMapping("updateBooks")
	public boolean updateBooks(@RequestBody BooksInventory book) {
		try {
			if(librarian.updateBooks(book)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return false;


	}//end of updateBooks

	@DeleteMapping("deleteBooks/{bookId}")
	public boolean deleteBooks(@PathVariable(name="bookId") String bookId) {
		try {
			if(librarian.deleteBooks(bookId)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return false;


	}//end of deleteBooks

	@GetMapping("showAllIssuedBook/{userId}")
	public List<BooksTransaction> showAllIssueBook(@PathVariable(name="userId") String userId) {

		List<BooksTransaction> bookList=null;

		try {
			librarian.showAllIssuedBooks(userId);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return bookList;
	}//end of showAllIssuedBooks

	@GetMapping("showAllIssuedBooks")
	public List<BooksTransaction> showAllIssuedBook() {
		List<BooksTransaction> bookList=null;
				try {
					librarian.showAllIssuedBooks();
				} catch (LibraryManagementException e) {
					e.printStackTrace();
				}
		return bookList;
	}//end of showAllIssuedBooks

	@GetMapping("showAllRequests")
	public List<BooksRegistration> showAllRequest() {
		List<BooksRegistration> bookList=null;
		try {
			bookList=librarian.showAllRequests();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return bookList;
	}//end of showAllRequests


	@GetMapping("acceptRequest/{registrationId}")
	public BooksTransaction acceptReq(@PathVariable(name="registrationId") String registrationId) {
		BooksTransaction trans=null;
		try {
			trans=librarian.acceptRequest(registrationId);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return trans;
	}//end of accept


	@PostMapping("returnBook/{returnDate}/{registrationId}")
	public BooksTransaction rtnBook(@PathVariable(name="returnDate") String returnDate, @PathVariable(name="registrationId") String registrationId) {
		Date rtnDate;
		try {
			rtnDate=new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
			BooksTransaction trans=librarian.returnBook(registrationId,rtnDate);
			return trans;
		}catch(ParseException | LibraryManagementException e) {
			e.printStackTrace();
		}
		return null;
	}//end of acceptRequest
}