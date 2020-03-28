package com.karlofab.demographql.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.karlofab.demographql.model.Author;
import com.karlofab.demographql.model.Book;
import com.karlofab.demographql.repository.AuthorRepository;
import com.karlofab.demographql.repository.BookRepository;

public class Query implements GraphQLResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}
