package com.homeorganizer.app.dto;

import com.homeorganizer.app.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HouseCleanerDto {
    private long id;
    private UserEntity user;
    private boolean isApproved;
    private LocalDate cleaningDate;
}

