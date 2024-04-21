package com.chien.jpasecurity;

import com.chien.jpasecurity.models.Author;
import com.chien.jpasecurity.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement
public class JpaSecurityApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaSecurityApplication.class, args);

  }

  @Bean
  @Transactional
  public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
    return args -> {
      for (int i = 3; i < 50; i++) {
        Faker faker = new Faker();
        var author = Author.builder().firstName(faker.name().firstName())
            .lastName(faker.name().lastName()).email("user" + i + "@mail.com")
            .age(faker.number().numberBetween(10, 80)).build();

        authorRepository.save(author);
      }

//      authorRepository.updateAuthor(100, 1);
//      List<Author> byNamedQuery = authorRepository.findByNamedQuery(100);
//      System.out.println(byNamedQuery);
/*    return args -> {
      var video = Video.builder().name("King Kong").length(5).build();
      videoRepository.save(video);*/
    };
  }

}
