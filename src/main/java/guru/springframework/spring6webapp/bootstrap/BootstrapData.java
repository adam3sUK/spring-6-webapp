package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(
    AuthorRepository authorRepository, 
    BookRepository bookRepository,
    PublisherRepository publisherRepository
    ) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
      Author adam = new Author();
      adam.setFirstName("Adam");
      adam.setLastName("Harbisher");

      Book ddd = new Book();
      ddd.setTitle("Learning Java for Dummies");
      ddd.setIsbn("123456");

      Publisher penguin = new Publisher();
      penguin.setPublisherName("Penguin");
      penguin.setAddress("42 Wallaby Way");
      penguin.setCity("Syndey");
      penguin.setState("Florida");
      penguin.setZip("1234");

      Author adamSaved = authorRepository.save(adam);
      Book dddSaved = bookRepository.save(ddd);
      Publisher publisherSaved = publisherRepository.save(penguin);

      dddSaved.setPublisher(publisherSaved);


      Author george = new Author();
      george.setFirstName("George");
      george.setLastName("Orwell");

      Book animalFarm = new Book();
      animalFarm.setTitle("Animal Farm");
      animalFarm.setIsbn("123457");

      Author georgeSaved = authorRepository.save(george);
      Book animalFarmSaved = bookRepository.save(animalFarm);

      animalFarmSaved.setPublisher(publisherSaved);

      georgeSaved.getBooks().add(animalFarmSaved);
      adamSaved.getBooks().add(dddSaved);

      authorRepository.save(georgeSaved);
      authorRepository.save(adamSaved);
      bookRepository.save(dddSaved);
      bookRepository.save(animalFarmSaved);

      System.out.println("In Bootstrap");

      System.out.println("author count: " + authorRepository.count());

      System.out.println("publisher count: " + publisherRepository.count());
  }
}




