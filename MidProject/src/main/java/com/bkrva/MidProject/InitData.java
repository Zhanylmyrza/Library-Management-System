package com.bkrva.MidProject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.bkrva.MidProject.modules.Book;
import com.bkrva.MidProject.modules.Borrow;
import com.bkrva.MidProject.repos.BookRepo;
import com.bkrva.MidProject.repos.BorrowRepo;
import java.util.ArrayList;
import java.util.List;


@Component
// @Profile("init")
public class InitData implements InitializingBean {

    @Autowired
    private BookRepo bookRepository;
    @Autowired
    private BorrowRepo borrowRepo;
    @Override
    public void afterPropertiesSet() {
        
        if (bookRepository.count() == 0) {
            
        
        List<Book> books = new ArrayList<>();
        
        Book book = new Book("White fang","Jack London", 1892, "3541354");
        Book book1 = new Book("Sherlock Holms","Arthur Conan ", 1892, "3541354");
        Book book2 = new Book( "Martin Eden", "Jack London",1909,"1234567");
        Book book3 = new Book( "Shantaram", "Gregory David ",1988,"102837");
        Book book4 = new Book( "Da Vinci Code", "Dan Brown ",1768,"176543");
        Book book5 = new Book( "1984", "Gregory Orwell",1988,"187654");
        
        
        Book book6 = new Book( "Blessed Rain", "Ibn Qayyim al-Jawziyya",1348,"100987");
        Book book7 = new Book( "Geniuses and outsiders", "Malcolm Gladwell",1498,"12345");
        Book book8 = new Book( "Heart Disease", "Ibn Qayyim al-Jawziyya",1998,"76547");
        Book book9 = new Book( "Foxhole", "Nora Sakavich",1287,"87657");
        Book book10 = new Book( "Morning magic", "Gregory Orwell",1821,"34537");
        
        
        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        
        List<Borrow> borrowers = new ArrayList<>();
        
        Borrow borrow1 = new Borrow("Zhanylmyrza","bkrvaa123@gmail.com",550345455);
        borrowers.add(borrow1);
        Borrow borrow2 = new Borrow("Sabina","sabina123@gmail.com",788934507);
        borrowers.add(borrow2);
        Borrow borrow3 = new Borrow("Ansari","ansari123@gmail.com",653434507);
        borrowers.add(borrow3);
        Borrow borrow4 = new Borrow("Halah","halah123@gmail.com",235434507);
        borrowers.add(borrow4);
        Borrow borrow5 = new Borrow("Fatima","fatima123@gmail.com",704834507);
        borrowers.add(borrow5);


        
        System.out.println("Before save: " + books);
        bookRepository.saveAll(books);
        System.out.println("After save: "+ books);
        
        borrow1.getBorrowedBooks().add(book);
        borrow1.getBorrowedBooks().add(book1);
        borrow1.getBorrowedBooks().add(book2);
        borrow1.getBorrowedBooks().add(book3);
        borrow1.getBorrowedBooks().add(book4);
        borrow1.getBorrowedBooks().add(book5);

        borrow2.getBorrowedBooks().add(book4);
        borrow2.getBorrowedBooks().add(book5);
        borrow2.getBorrowedBooks().add(book1);
        borrow2.getBorrowedBooks().add(book3);


        borrow3.getBorrowedBooks().add(book3);
        borrow3.getBorrowedBooks().add(book2);
        borrow3.getBorrowedBooks().add(book);
        borrow3.getBorrowedBooks().add(book4);


        borrow4.getBorrowedBooks().add(book2);
        borrow4.getBorrowedBooks().add(book3);
        borrow4.getBorrowedBooks().add(book);
        borrow4.getBorrowedBooks().add(book5);


        borrow5.getBorrowedBooks().add(book);
        borrow5.getBorrowedBooks().add(book2);
        borrow5.getBorrowedBooks().add(book5);
        borrow5.getBorrowedBooks().add(book3);


        borrowRepo.saveAll(borrowers);
        
    }
    }
}

