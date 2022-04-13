package pl.home.organizer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseCleanerDto {
    private long id;
    private String userId;
    private boolean isApproved;
    private String cleaningDate;
}

