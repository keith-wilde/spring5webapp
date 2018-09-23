package com.kwilde.spring5webapp.repositories;

import com.kwilde.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
