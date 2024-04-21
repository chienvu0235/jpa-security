package com.chien.jpasecurity.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass // super-class, not entity
public class BaseEntity {

  @Id
  @GeneratedValue
//      (
//      strategy = GenerationType.SEQUENCE,
//      generator = "author_sequence"
//  )
//  @SequenceGenerator(
//      name = "author_sequence",
//      sequenceName = "author_sequence",
//      allocationSize = 1
//  )
  private Integer id;

  private LocalDateTime createdAt;
  private LocalDateTime lastModifiedAt;

  private String createdBy;
  private String lastModifiedBy;

}
