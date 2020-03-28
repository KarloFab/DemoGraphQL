package com.karlofab.demographql;

import com.karlofab.demographql.model.Author;
import com.karlofab.demographql.model.Book;
import com.karlofab.demographql.mutation.Mutation;
import com.karlofab.demographql.query.Query;
import com.karlofab.demographql.repository.AuthorRepository;
import com.karlofab.demographql.repository.BookRepository;
import com.karlofab.demographql.resolver.BookResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemographqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemographqlApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
		};
	}
}
