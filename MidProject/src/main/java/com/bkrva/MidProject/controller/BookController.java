package com.bkrva.MidProject.controller;
import com.bkrva.MidProject.modules.Book;
import com.bkrva.MidProject.repos.BookRepo;
import javax.validation.Valid;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.*;




@Controller
@RequestMapping(value = "books", method = { RequestMethod.GET, RequestMethod.POST })
public class BookController {
    
    @Autowired
    private BookRepo bookRepository;
    @GetMapping("borrowBook")
    public String showForm(Book book) {
        return "register";
    }

    @GetMapping("list")
    public String showBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "main";
    }
    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id ));
        model.addAttribute("book",book);
        model.addAttribute("header", String.format("Update book \"%s\"",book.getTitle()));
        return "add-book";

    }
    @PostMapping("update/{id}")
    public String updateBooks(@PathVariable("id") long id, Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            book.setId(id);
            return "update-book";
        }
        bookRepository.save(book);
        model.addAttribute("books",bookRepository.findAll());
        return "main";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model ){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id ));
        bookRepository.delete(book);
        model.addAttribute("book", bookRepository.findAll());
        return "redirect:/";

    }
    
    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("header", "Create new book");
        return "add-book";
    }
    
   
    @GetMapping("/books")
    public String getAllBooks(Model model, String keyword){
        
        
        if(keyword != null){
            model.addAttribute("books", BookService.findByKeyword(keyword));
        }
        else{
            model.addAttribute("books", BookService.getAllBooks());
        }
        return "Book"; 
        

    }
    
    @GetMapping("/search")
    public String searchBook(Model model, String keyword) {
        System.out.println(keyword);
        model.addAttribute( "books", bookRepository.findByKeyword(keyword));
        return "main";
    }
    
    

}

