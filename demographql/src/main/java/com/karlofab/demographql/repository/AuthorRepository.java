package com.karlofab.demographql.repository;

import com.karlofab.demographql.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
