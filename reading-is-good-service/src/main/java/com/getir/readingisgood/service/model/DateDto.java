package com.getir.readingisgood.service.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class DateDto extends BaseDto{
    private Instant createdAt;
    private Instant updatedAt;

}
