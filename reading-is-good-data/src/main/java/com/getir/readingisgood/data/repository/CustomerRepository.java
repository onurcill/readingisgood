package com.getir.readingisgood.data.repository;

import com.getir.readingisgood.data.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long>,
        JpaSpecificationExecutor<CustomerEntity> {

    Optional<CustomerEntity> findByEmailIgnoreCase(String email);
}