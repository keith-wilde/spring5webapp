package com.kwilde.spring5webapp.repositories;

import com.kwilde.spring5webapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {


}
