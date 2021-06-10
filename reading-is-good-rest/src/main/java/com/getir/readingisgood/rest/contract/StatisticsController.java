package com.getir.readingisgood.rest.contract;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/v1/statistics")
@Api(tags = "Statistic")
public interface StatisticsController {
}
