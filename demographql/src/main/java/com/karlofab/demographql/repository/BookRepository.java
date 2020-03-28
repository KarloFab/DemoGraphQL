package com.karlofab.demographql.repository;

import com.karlofab.demographql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
