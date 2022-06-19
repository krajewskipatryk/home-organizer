package pl.home.organizer.application.dto;

import lombok.Getter;
import lombok.Setter;
import pl.home.organizer.application.entity.UserEntity;

import java.time.LocalDate;

@Getter
@Setter
public class HouseCleanerDto {
    private static final long serialVersionUID = -6295402573104359355L;
    private long id;
    private UserEntity user;
    private boolean isApproved;
    private LocalDate cleaningDate;
}

