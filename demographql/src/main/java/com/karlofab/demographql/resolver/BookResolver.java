package com.karlofab.demographql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.karlofab.demographql.model.Author;
import com.karlofab.demographql.model.Book;
import com.karlofab.demographql.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book){
        return authorRepository.getOne(book.getAuthor().getId());
    }
}
