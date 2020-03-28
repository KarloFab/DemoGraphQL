package com.karlofab.demographql.repository;

import com.karlofab.demographql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
