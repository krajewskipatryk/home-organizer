package com.homeorganizer.app.dto;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CleaningDto {
    private Long id;
    private LocalDate lastCleaningDate;
    private LocalDate nextCleaningDate;
    private UserEntity recentlyCleaningUser;
    private UserEntity nextCleaningUser;
    private GroupEntity assignedGroup;
}
