package com.chien.jpasecurity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COURSE_TBL")
public class Course {

  @Id
  @GeneratedValue
  private Integer id;

  private String title;

  private String description;

  @ManyToMany(fetch = FetchType.EAGER)
  @JsonIgnore
  @JoinTable(name = "authors_courses", joinColumns = {
      @JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name = "author_id")})
  private List<Author> authors;

  @OneToMany(mappedBy = "course")
  @JsonIgnore
  private List<Section> sections;

}
