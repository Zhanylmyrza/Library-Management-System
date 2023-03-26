package com.bkrva.MidProject.modules;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.ISBN;


@Setter
@Getter
@ToString
@Entity
@Table(name = "book")
public class Book {
    
  @Id @GeneratedValue
  private Long id;
  private String title;  
  private String author;
  private int publisher;
  
  // @ISBN
  private String ISBN;
  
  private static final Set<Borrow> Borrow = null;
  
  public Book() {
  }
  
  public Book(String title, String author, int publisher, String ISBN) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.ISBN = ISBN;
  }
  
  
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPublisher() {
    return this.publisher;
  }

  public void setPublisher(int publisher) {
    this.publisher = publisher;
  }

  public String getISBN() {
    return this.ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }
  
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Book book = (Book) o;
      return id == book.id;
  }
  @Override
  public int hashCode() {
      return Objects.hash(id);
  }
  @Override
  public String toString() {
      return "Book{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", isbn='" + ISBN + '\'' +
              '}';
  }
  
  
   
  @ManyToMany(mappedBy = "borrowedBooks")
  Set<Borrow> borrows;
 
  public Set<Borrow> getBorrows() {
    return this.borrows;
  }
  public void setBorrows(Set<Borrow> borrow) {
    this.borrows = borrow;
  } 
  
  
  public Book addBorrower(Borrow borrow) {
    if (borrows == null)
        borrows = new HashSet<>();

    Borrow.add(borrow);
    return this;
  }
  
}
