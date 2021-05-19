package io.kameloon.demo.repo;

import io.kameloon.demo.entity.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {
    @Query("select q from Quote q order by q.createDate desc ")
    public List<Quote> getAll();

    public void deleteById(Long id);
}
