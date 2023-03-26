package com.bkrva.MidProject.repos;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkrva.MidProject.modules.Book;

@Repository
public interface BookRepo extends  JpaRepository<Book, Long> {
  List<Book> findAll();
  
  List<Book> findBookByTitle(String title);
  
  @Query(value = "select * from Book b where b.title ilike %:keyword% ", nativeQuery = true)
  List<Book> findByKeyword(@Param("keyword") String keyword);
  
  
}
