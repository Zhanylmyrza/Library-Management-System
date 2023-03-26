package com.bkrva.MidProject.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bkrva.MidProject.modules.Book;
import com.bkrva.MidProject.modules.Borrow;
import com.bkrva.MidProject.repos.BookRepo;
import com.bkrva.MidProject.repos.BorrowRepo;



@Controller
public class MainController {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BorrowRepo borrowRepo;
    
    @Autowired
    private BookService service;
    

    @GetMapping({"/","/index"})
    public String main(Model model) {

        System.out.println("Main page requested");
        model.addAttribute("word", "Hello World!");
        model.addAttribute("books", bookRepo.findAll());

        return "main";
    }
    
    @GetMapping("borrow")
    public String borrowers(Model model){
        model.addAttribute("borrowers", borrowRepo.findAll());
        return "borrowers";
    }
    
    @GetMapping("show-books/{borrowId}")
    public String showBook(@PathVariable long borrowId, Model model){
        Borrow borrower = borrowRepo.findById(borrowId).orElseThrow();
        Set<Book> borrowedBooks = borrower.getBorrowedBooks();
        model.addAttribute("books", borrowedBooks);
        return "show-books";
    }
    
    

    

}
