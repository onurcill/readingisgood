package com.getir.readingisgood.data.repository;

import com.getir.readingisgood.data.model.OrderEntity;
import com.getir.readingisgood.data.model.OrderStatistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long>,
        JpaSpecificationExecutor<OrderEntity> {

    Page<OrderEntity> findAllByCustomerId(Long id, Pageable pageable);

    Page<OrderEntity> findAllByDateCreatedIsBetween(Date startDate, Date endDate, Pageable pageable);

    @Query(value = "SELECT new com.getir.readingisgood.data.model.OrderStatistics(count(o), sum(o.totalPrice), sum(o.totalQuantity), MONTH(o.dateCreated)) FROM orders o "
            + "where o.customer.id = :id "
            + "group by MONTH(o.dateCreated), YEAR(dateCreated)")
    List<OrderStatistics> findStatisticsByCustomerId(Long id);


}
