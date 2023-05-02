package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
      Author adam = new Author();
      adam.setFirstName("Adam");
      adam.setLastName("Harbisher");

      Book ddd = new Book();
      ddd.setTitle("Learning Java for Dummies");
      ddd.setIsbn("123456");

      Author adamSaved = authorRepository.save(adam);
      Book dddSaved = bookRepository.save(ddd);

      Author george = new Author();
      george.setFirstName("George");
      george.setLastName("Orwell");

      Book animalFarm = new Book();
      animalFarm.setTitle("Animal Farm");
      animalFarm.setIsbn("123457");

      Author georgeSaved = authorRepository.save(george);
      Book animalFarmSaved = bookRepository.save(animalFarm);

      georgeSaved.getBooks().add(animalFarmSaved);
      adamSaved.getBooks().add(dddSaved);

      System.out.println("In Bootstrap");

      System.out.println("author count:" + authorRepository.count());
  }
}




