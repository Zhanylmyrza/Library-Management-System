package com.bkrva.MidProject.repos;


import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import com.bkrva.MidProject.modules.Borrow;


public interface BorrowRepo extends CrudRepository<Borrow,Long> {
  Set<Borrow> findAll();
}
