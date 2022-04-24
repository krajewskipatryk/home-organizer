package pl.home.organizer.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseCleanerDto {
    private String id;
    private boolean isApproved;
    private String cleaningDate;
}

