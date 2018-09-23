package com.kwilde.spring5webapp.bootstrap;

import com.kwilde.spring5webapp.model.Author;
import com.kwilde.spring5webapp.model.Book;
import com.kwilde.spring5webapp.model.Publisher;
import com.kwilde.spring5webapp.repositories.AuthorRepository;
import com.kwilde.spring5webapp.repositories.BookRepository;
import com.kwilde.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    //Framework autowires the repositories in here
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric", "Events");
        Publisher p1 = new Publisher("Harper Collins","123 fake street");
        Book ddd = new Book("Domain driven Design", "1234", p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(p1);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        Author rod = new Author("Rod", "Johnson");
        Publisher p2 = new Publisher("WORX","123 fake street, Colorado Road, UT");
        Book noEJB = new Book("J2ee development without ejb", "12345", p2);
        rod.getBooks().add(noEJB);
        publisherRepository.save(p2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
