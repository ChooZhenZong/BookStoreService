package com.dxc.bookstore.api.bookstoreservice.respository;

import com.dxc.bookstore.api.bookstoreservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthors_Name(String name);
}
