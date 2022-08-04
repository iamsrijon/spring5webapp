package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher vodai = new Publisher("Vodai", "afdfsasdf", "beaumont", "TX", "77705");
        publisherRepository.save(vodai);

        Author eric  = new Author("Eric", "Banah");
        Book hudai = new Book("Hudai", "1212121", vodai);

        eric.getBooks().add(hudai);
        hudai.getAuthors().add(eric);


        Author rod  = new Author("Rod", "Johnson");
        Book j2eeDevelBook = new Book("J2EE Development", "12153434", vodai);
        rod.getBooks().add(j2eeDevelBook);
        j2eeDevelBook.getAuthors().add(rod);

        authorRepository.save(rod);
        authorRepository.save(eric);

        bookRepository.save(hudai);
        bookRepository.save(j2eeDevelBook);

        System.out.println("Starting in bootstrap");
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
