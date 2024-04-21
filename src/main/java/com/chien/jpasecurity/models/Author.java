package com.chien.jpasecurity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHOR_TBL")
@NamedQuery(name = "Author.findByNamedQuery", query = "select a from Author a where a.age >= :age")
public class Author extends BaseEntity {

  @Column(name = "f_name", length = 35)
  private String firstName;
  private String lastName;
  private int age;

  @Column(unique = true, nullable = false)
  private String email;

  private LocalDateTime createdAt;
  private LocalDateTime lastModified;


  @ManyToMany(mappedBy = "authors")
  private List<Course> courses;

}
