package com.chien.jpasecurity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  //  @Bean(name = {"Joseph", "Lars"})
//  public Author getAuthor() {
//    return Author.builder().email("hello@gmail.com").build();
//  }
  @PostConstruct
  public void postConstruct() {
    System.out.println("\t>> Đối tượng Girl sau khi khởi tạo xong sẽ chạy hàm này");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("\t>> Đối tượng Girl trước khi bị destroy thì chạy hàm này");
  }
}
