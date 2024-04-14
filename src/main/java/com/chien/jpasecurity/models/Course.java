package com.chien.jpasecurity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COURSE_TBL")
public class Course {

  @Id
  @GeneratedValue
  private Integer id;

  private String title;

  private String description;

  @ManyToMany()
  @JoinTable(name = "authors_courses", joinColumns = {
      @JoinColumn(
          name = "course_id"
      )},
      inverseJoinColumns = {
      @JoinColumn(name = "author_id")
  })
  private List<Author> authors;

  @OneToMany(mappedBy = "course")
  private List<Section> sections;

}