package com.bkrva.MidProject.modules;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Borrow {

  @Id @GeneratedValue
  private Long id;
  private String name;
  private String email;
  private int phone;
  
  public Borrow(){
    
  }
  public Borrow(String name, String email, int phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getPhone() {
    return this.phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }
  

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Borrow)) {
            return false;
        }
        Borrow borrow = (Borrow) o;
        return Objects.equals(id, borrow.id) && Objects.equals(name, borrow.name) && Objects.equals(email, borrow.email) && phone == borrow.phone && Objects.equals(borrowedBooks, borrow.borrowedBooks);
  }
  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, phone, borrowedBooks);
  }
  @ManyToMany
  Set<Book> borrowedBooks=new HashSet<>();

  public Set<Book> getBorrowedBooks() {
    return borrowedBooks;
  }
  public void setBorrowedBooks(Set<Book> borrowedBooks) {
    this.borrowedBooks = borrowedBooks;
  }

 
  


  
}
