package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.StatisticsResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@RequestMapping("/api/v1/statistics")
@Api(tags = "Statistic")
public interface StatisticsController {

    @GetMapping("/{id}")
    ResponseEntity<List<StatisticsResponse>> getCustomerMonthlyStatistics(@PathVariable Long id);
}
