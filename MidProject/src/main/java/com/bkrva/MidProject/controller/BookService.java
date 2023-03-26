package com.bkrva.MidProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bkrva.MidProject.modules.Book;
import com.bkrva.MidProject.repos.BookRepo;

@Service
public class BookService {
  @Autowired
  private static BookRepo repository;
 
 
 public static List<Book> getAllBooks(){
  List<Book> list =  (List<Book>)repository.findAll();
  return list;
 }
 

  public static List<Book> findByKeyword(String keyword) {
    return repository.findByKeyword(keyword);
  }
 
}
