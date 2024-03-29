package com.karlofab.demographql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.karlofab.demographql.model.Author;
import com.karlofab.demographql.model.Book;
import com.karlofab.demographql.repository.AuthorRepository;
import com.karlofab.demographql.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(bookRepository.findById(id).get());
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
