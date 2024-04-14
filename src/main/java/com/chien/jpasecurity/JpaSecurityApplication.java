package com.chien.jpasecurity;

import com.chien.jpasecurity.models.Author;
import com.chien.jpasecurity.models.Video;
import com.chien.jpasecurity.repositories.AuthorRepository;
import com.chien.jpasecurity.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaSecurityApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(JpaSecurityApplication.class, args);
    Config config = context.getBean(Config.class);

    context.getBeanFactory().destroyBean(config);

  }

  @Bean
  public CommandLineRunner commandLineRunner(AuthorRepository authorRepository,
      VideoRepository videoRepository) {
//		return args -> {
//			var author = Author.builder()
//					.firstName("Chien")
//					.lastName("Vu")
//					.email("chien@mail.com")
//					.age(21)
//					.build();
//
//			authorRepository.save(author);
    return args -> {
      var video = Video.builder().name("King Kong").length(5).build();
      videoRepository.save(video);
    };
  }

}
