package com.getir.readingisgood.data.repository;

import com.getir.readingisgood.data.model.BookEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long>,
        JpaSpecificationExecutor<BookEntity> {
}