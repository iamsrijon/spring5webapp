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
        Book hudai = new Book("Hudai", "121212");
        hudai.setPublisher(vodai);

        eric.getBooks().add(hudai);
        hudai.getAuthors().add(eric);
        vodai.getBooks().add(hudai);

        authorRepository.save(eric);
        bookRepository.save(hudai);
        publisherRepository.save(vodai);

        Author rod  = new Author("Rod", "Johnson");
        Book j2eeDevelBook = new Book("J2EE Development", "12153434");
        j2eeDevelBook.setPublisher(vodai);
        j2eeDevelBook.getAuthors().add(rod);
        rod.getBooks().add(j2eeDevelBook);
        vodai.getBooks().add(j2eeDevelBook);

        authorRepository.save(rod);
        bookRepository.save(j2eeDevelBook);
        publisherRepository.save(vodai);

        System.out.println("Starting in bootstrap");
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("Published Books: " + vodai.getBooks());

    }
}
