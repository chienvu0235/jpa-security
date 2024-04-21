package com.chien.jpasecurity.controller;

import com.chien.jpasecurity.models.Author;
import com.chien.jpasecurity.models.Author_;
import com.chien.jpasecurity.repositories.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorRepository authorRepository;

  @PersistenceContext
  private EntityManager entityManager;

  // JPQL
  public List<?> getAuthorsByJpql(int id) {
    Query query = entityManager.createQuery("SELECT a FROM Author a WHERE a.id = :id",
        Author.class);
    query.setParameter(Author_.ID, id);
    return query.getResultList();
  }

  public List<?> getAuthorsByCriteria(int id) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
    Root<Author> root = criteriaQuery.from(Author.class);

    criteriaQuery.select(root).where(criteriaBuilder.gt(root.get(Author_.ID), id));
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  public int updateAuthorsByCriteria(Author author) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaUpdate<Author> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Author.class);
    Root<Author> root = criteriaUpdate.from(Author.class);

    criteriaUpdate.set(Author_.firstName, author.getFirstName())
        .where(criteriaBuilder.gt(root.get(Author_.ID), author.getId()));
    Query query = entityManager.createQuery(criteriaUpdate);
    return query.executeUpdate();
  }

  @GetMapping("/get")
  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

  @GetMapping("/jpql/{id}")
  public List<?> getAuthorByJpql(@PathVariable int id) {
    return getAuthorsByJpql(id);
  }

  @GetMapping("/criteria/{id}")
  public List<?> getAuthorByCriteria(@PathVariable int id) {
    return getAuthorsByCriteria(id);
  }

  @PutMapping
  public int updateAuthor(@RequestBody Author author) {
    return updateAuthorsByCriteria(author);
  }
}
