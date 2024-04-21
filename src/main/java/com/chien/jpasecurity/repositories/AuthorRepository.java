package com.chien.jpasecurity.repositories;

import com.chien.jpasecurity.models.Author;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Transactional
  List<Author> findByNamedQuery(@Param("age") int age);

  @Modifying
  @Transactional
  @Query("update Author a set a.age = :age where a.id = :id")
  int updateAuthor(int age, int id);

//  List<Author> findAllByFirstName(String firstName);
//
//  List<Author> findAllByFirstNameIgnoreCase(String firstName);
//
//  List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);
//  List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);
//  List<Author> findAllByFirstNameInIgnoreCase(String... firstName);

}
